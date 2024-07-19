/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 10:44 AM
 */
package com.ceyentra.sm.dto.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorMessageResponseDTO {

    private int status;
    private boolean success;
    private String message;
}
