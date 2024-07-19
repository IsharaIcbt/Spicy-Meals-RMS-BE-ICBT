/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 11:07 AM
 */
package com.ceyentra.sm.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;


@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {

    public CustomOauthException(String msg) {
        super(msg);
    }
}
