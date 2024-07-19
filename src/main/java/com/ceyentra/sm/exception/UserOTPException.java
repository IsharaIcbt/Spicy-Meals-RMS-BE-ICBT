/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 1:52 PM
 */
package com.ceyentra.sm.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserOTPException extends RuntimeException {

    private boolean success;
    private int status;
    private String message;

    public UserOTPException(int status, boolean success, String message) {
        super(message);
        this.status = status;
        this.success = success;
        this.message = message;
    }
}
