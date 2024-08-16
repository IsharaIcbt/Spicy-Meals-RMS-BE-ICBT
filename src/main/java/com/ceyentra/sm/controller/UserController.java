package com.ceyentra.sm.controller;

import com.ceyentra.sm.config.throttling_config.Throttling;
import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.dto.web.request.UserPasswordResetRequestDTO;
import com.ceyentra.sm.dto.web.request.ValidateUserOTPRequestDTO;
import com.ceyentra.sm.dto.web.response.UserResponseDTO;
import com.ceyentra.sm.enums.UserStatus;
import com.ceyentra.sm.service.UserOTPService;
import com.ceyentra.sm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.ceyentra.sm.constant.FunctionalConstant.USER_DTO_LIST_USER_RESPONSE_DTO_LIST_FUNCTION;
import static com.ceyentra.sm.constant.FunctionalConstant.USER_DTO_USER_RESPONSE_DTO_FUNCTION;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserOTPService userOTPService;

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("User successfully registered.")
                        .build()
                , HttpStatus.OK
        );
    }

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   /* @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")*/
    public ResponseEntity<ResponseDTO<Object>> getAllUsers(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "value", required = false) String value) {

        Object data = null;

        if (key != null && value != null)
            if ("email".equals(key)) {
                data = USER_DTO_USER_RESPONSE_DTO_FUNCTION.apply(userService.findUserByEmail(value));
            }

        //if no filter found.return all users
        return new ResponseEntity<>(
                new ResponseDTO<>(
                        true, data == null ? USER_DTO_LIST_USER_RESPONSE_DTO_LIST_FUNCTION
                        .apply(userService.getAllUsersByStatus(UserStatus.ACTIVE)) : data)
                , HttpStatus.OK);
    }

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_MANAGER','ROLE_SAMPLE_ROOM_EMPLOYEE','ROLE_BUYER')")
    public ResponseEntity<ResponseDTO<UserResponseDTO>> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(
                new ResponseDTO<>(
                        true, USER_DTO_USER_RESPONSE_DTO_FUNCTION
                        .apply(userService.getUserByUserId(id)))
                , HttpStatus.OK);
    }

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @PutMapping(value = "/deactivate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<CommonResponseDTO> deactivateUser(@PathVariable Long id) {
        userService.updateUserStatus(id, UserStatus.INACTIVE);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("User successfully deactivated.")
                        .build()
                , HttpStatus.OK);
    }

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<CommonResponseDTO> deleteUser(@PathVariable Long id) {
        userService.updateUserStatus(id, UserStatus.DELETED);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("User successfully deleted.")
                        .build()
                , HttpStatus.OK);
    }

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @PutMapping(value = "/password-reset", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> updateUserPassword(
            @RequestBody(required = false) UserPasswordResetRequestDTO requestDTO,
            @RequestParam(value = "email", required = false) String email) {

        boolean success = true;

        if (email != null) {
            userService.resetUserPassword(email);
        } else if (requestDTO != null) {
            userService.resetUserPassword(requestDTO.getEmail(), requestDTO.getOtp(), requestDTO.getPassword());
        } else {
            success = false;
        }
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(success)
                        .message(success ? "Password has been reset successfully." : "Unable to reset password.")
                        .build()
                , HttpStatus.OK);
    }

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 10)
    @PostMapping(value = "otp/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> sendUserOTP(@RequestParam(value = "email") String email) {
        userService.sendUserOTP(email);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message(String.format("OTP has been sent successfully to %s.", email))
                        .build()
                , HttpStatus.OK);
    }

    /**
     * View all subscription packages
     *
     * @return if authentication token is expire return "error": "invalid_token", and error_description http status -401
     * * if authentication access failed  return "error": "access_denied", "error_description": "Access is denied" http status 403
     * * if operation successfully return success=true and success message or relevant data, http status -200
     * * if operation failed return success=false and failed message, http status -200
     * * if internal server error or custom error occurred return success=false and relevant failed message, http status -500/200
     */
    @Throttling(timeFrameInSeconds = 60, calls = 10)
    @PostMapping(value = "otp/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> validateUserOTP(@RequestBody ValidateUserOTPRequestDTO requestDTO) {
        userOTPService.validateUserOTP(requestDTO.getEmail(), requestDTO.getOtp());
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("Your OTP has been successfully verified.")
                        .build()
                , HttpStatus.OK);
    }

}
