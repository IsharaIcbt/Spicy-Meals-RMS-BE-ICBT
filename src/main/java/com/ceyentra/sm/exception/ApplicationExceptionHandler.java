/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 10:26 AM
 */
package com.ceyentra.sm.exception;

import com.ceyentra.sm.dto.common.ErrorMessageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.ceyentra.sm.constant.ApplicationConstant.APPLICATION_ERROR_OCCURRED_MESSAGE;
import static com.ceyentra.sm.constant.ApplicationConstant.UNAUTHORIZED_USER;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
   /** handle Application exception */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessageResponseDTO> handleAnyException(Exception exception) {
        return new ResponseEntity<>(
                ErrorMessageResponseDTO.builder()
                        .status(100)
                        .success(false)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.OK);
    }


    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<ErrorMessageResponseDTO> handleUserException(UserException exception) {
        return new ResponseEntity<>(
                ErrorMessageResponseDTO.builder()
                        .status(exception.getStatus())
                        .success(exception.isSuccess())
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.OK);
    }

    @ExceptionHandler(value = {CustomOauthException.class})
    public ResponseEntity<ErrorMessageResponseDTO> handleCustomOAuth2Exception(CustomOauthException exception) {
        return new ResponseEntity<>(
                ErrorMessageResponseDTO.builder()
                        .status(UNAUTHORIZED_USER)
                        .success(false)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.OK);
    }

    @ExceptionHandler(value = {ApplicationServiceException.class})
    public ResponseEntity<ErrorMessageResponseDTO> handleApplicationException(ApplicationServiceException exception) {
        return new ResponseEntity<>(
                ErrorMessageResponseDTO.builder()
                        .status(exception.getStatus())
                        .success(false)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.OK);
    }

    @ExceptionHandler(value = {UserOTPException.class})
    public ResponseEntity<ErrorMessageResponseDTO> handleUserOTPExceptionException(UserOTPException exception) {
        return new ResponseEntity<>(
                ErrorMessageResponseDTO.builder()
                        .status(exception.getStatus())
                        .success(false)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.OK);
    }
}
