package com.ceyentra.sm.controller;

import com.ceyentra.sm.config.throttling_config.Throttling;
import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.web.request.SaveAdminReqDTO;
import com.ceyentra.sm.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

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
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<CommonResponseDTO> registerUser(@RequestBody SaveAdminReqDTO saveAdminReqDTO) {
        adminService.saveAdmin(saveAdminReqDTO);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("Admin successfully registered.")
                        .build()
                , HttpStatus.OK
        );
    }
}
