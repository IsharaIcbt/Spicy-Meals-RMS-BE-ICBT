/**
 * @author :  Dinuth Dheeraka
 * Created : 8/6/2023 2:16 AM
 */
package com.ceyentra.sm.util;

import com.ceyentra.sm.constant.OAuth2Constant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JwtTokenClaimsExtractor {

    public String extractUsername(String jwtToken) {
        log.info("start function extractUsername @Params jwtToken : {}",jwtToken);
        try{
            return (String) extractAllClaims(jwtToken).get("user_name");
        }catch (Exception e){
            log.error("function extractAllClaims : {}", e.getMessage(), e);
            throw e;
        }
    }

    public Claims extractAllClaims(String jwtToken) {
        log.info("start function extractAllClaims @Params jwtToken : {}",jwtToken);
        try {
            return Jwts
                    .parser()
                    .setSigningKey(OAuth2Constant.TOKEN_SIGN_IN_KEY.getBytes())
                    .parseClaimsJws(jwtToken.substring(7))
                    .getBody();

        } catch (Exception e){
            log.error("function extractAllClaims : {}", e.getMessage(), e);
            throw e;
        }
    }
}
