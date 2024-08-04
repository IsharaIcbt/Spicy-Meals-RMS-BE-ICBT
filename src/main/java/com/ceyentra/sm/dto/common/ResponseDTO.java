/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 12:43 PM
 */
package com.ceyentra.sm.dto.common;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {
    private boolean success;
    private T data;
}
