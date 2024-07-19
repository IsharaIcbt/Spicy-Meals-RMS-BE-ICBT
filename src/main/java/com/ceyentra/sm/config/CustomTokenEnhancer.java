/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 12:19 PM
 */
package com.ceyentra.sm.config;

import com.ceyentra.sm.constant.OAuth2Constant;
import com.ceyentra.sm.dto.web.response.UserResponseDTO;
import com.ceyentra.sm.service.OAuth2UserService;
import com.ceyentra.sm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.ceyentra.sm.constant.FunctionalConstant.USER_DTO_USER_RESPONSE_DTO_FUNCTION;

@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    private final OAuth2UserService oauth2UserService;
    private final HttpServletRequest request;
    private final BCryptPasswordEncoder encoder;
    private final UserService userService;

    @Autowired
    public CustomTokenEnhancer(OAuth2UserService oauth2UserService, HttpServletRequest request, BCryptPasswordEncoder encoder, UserService userService) {
        this.oauth2UserService = oauth2UserService;
        this.request = request;
        this.encoder = encoder;
        this.userService = userService;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        final Map<String, Object> additionalInfo = new HashMap<>();

        User user = (User) oAuth2Authentication.getPrincipal();

        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        User account = (User) authentication.getPrincipal();


        final UserResponseDTO userAdditionalInfo = USER_DTO_USER_RESPONSE_DTO_FUNCTION
                .apply(userService.findUserByEmail(user.getUsername()));

        switch (account.getUsername()) {
            case OAuth2Constant.ADMIN_CLIENT_ID:
                additionalInfo.put("admin", userAdditionalInfo);
                break;

            case OAuth2Constant.USER_CLIENT_ID:
                additionalInfo.put("user", userAdditionalInfo);
                break;
        }
        // set custom claims
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return super.enhance(oAuth2AccessToken, oAuth2Authentication);
    }
}
