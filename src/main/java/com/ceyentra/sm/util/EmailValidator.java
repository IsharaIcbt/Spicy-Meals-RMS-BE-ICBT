/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 2:09 PM
 */
package com.ceyentra.sm.util;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public boolean isValidEmail(String email){
        return email.matches(EMAIL_REGEX);
    }

}
