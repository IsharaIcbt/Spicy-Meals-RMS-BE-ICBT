/**
 * @author :  Dinuth Dheeraka
 * Created : 8/7/2023 10:16 AM
 */
package com.ceyentra.sm.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationServiceException extends RuntimeException {

    private int status;
    private boolean success;
    private String message;

    public ApplicationServiceException(int status, boolean success, String message) {
        super(message);
        this.status = status;
        this.success = success;
        this.message = message;
    }
}
