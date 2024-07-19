/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 10:29 AM
 */
package com.ceyentra.sm.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserException extends RuntimeException {

    private boolean success;
    private int status;
    private String message;

    public UserException(int status, boolean success, String message) {
        super(message);
        this.status = status;
        this.success = success;
        this.message = message;
    }
}
