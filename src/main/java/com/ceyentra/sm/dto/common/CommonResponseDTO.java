/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 10:45 AM
 */
package com.ceyentra.sm.dto.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CommonResponseDTO {

    private boolean success;
    private String message;
}
