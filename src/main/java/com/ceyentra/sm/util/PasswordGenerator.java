/**
 * @author :  Dinuth Dheeraka
 * Created : 8/7/2023 12:08 PM
 */
package com.ceyentra.sm.util;

import com.ceyentra.sm.exception.ApplicationServiceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.ceyentra.sm.constant.ApplicationConstant.COMMON_ERROR_CODE;

@Log4j2
@Component
public class PasswordGenerator {

    public String generatePassword(int length) {
        try {
            String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
            String specialCharacters = "!@#$";
            String numbers = "1234567890";
            String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
            Random random = new Random();
            char[] password = new char[length];

            password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
            password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
            password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
            password[3] = numbers.charAt(random.nextInt(numbers.length()));

            for (int i = 4; i < length; i++) {
                password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
            }
            return String.valueOf(password);
        } catch (Exception e) {
            log.error("generatePassword : {}", e.getMessage(), e);
            throw new ApplicationServiceException(COMMON_ERROR_CODE, false, "Password generate process failed");
        }
    }

}
