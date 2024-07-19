/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 11:39 AM
 */
package com.ceyentra.sm.util;

import com.ceyentra.sm.exception.ApplicationServiceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.ceyentra.sm.constant.ApplicationConstant.COMMON_ERROR_CODE;

@Component
@Log4j2
public class OTPGenerator {

    private final Random random = new Random();

    public int generateOTP() {
        log.info("start function generateOTP");
        try {
            return random.nextInt(9000) + 1000;
        } catch (Exception e) {
            log.error("generateOTP : {}", e.getMessage(), e);
            throw new ApplicationServiceException(COMMON_ERROR_CODE, false, "OTP generate process failed");
        }
    }
}
