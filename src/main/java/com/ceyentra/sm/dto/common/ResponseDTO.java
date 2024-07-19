/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 12:43 PM
 */
package com.ceyentra.sm.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private boolean success;
    private T data;
}
