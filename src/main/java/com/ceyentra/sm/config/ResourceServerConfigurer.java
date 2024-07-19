/**
 * @author :  Dinuth Dheeraka
 * Created : 8/10/2023 5:38 PM
 */
package com.ceyentra.sm.config;

import com.ceyentra.sm.constant.ApplicationConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                //user end-points

                .antMatchers(HttpMethod.POST, ApplicationConstant.API_BASE_URL + "/user/otp/**")
                .permitAll()

                .antMatchers(HttpMethod.PUT, ApplicationConstant.API_BASE_URL + "/password-reset")
                .permitAll()

                .antMatchers(HttpMethod.POST, ApplicationConstant.API_BASE_URL + "/user")
                .access("hasAnyRole('ROLE_ADMIN')")

                .antMatchers(HttpMethod.GET, ApplicationConstant.API_BASE_URL + "/user")
                .access("hasAnyRole('ROLE_ADMIN')")

                .antMatchers(HttpMethod.GET, ApplicationConstant.API_BASE_URL + "/user/{id}")
                .access("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_SAMPLE_ROOM_EMPLOYEE','ROLE_BUYER')")

                .antMatchers(HttpMethod.PUT, ApplicationConstant.API_BASE_URL + "/user/deactivate/{id}")
                .access("hasAnyRole('ROLE_ADMIN')")

                .antMatchers(HttpMethod.DELETE, ApplicationConstant.API_BASE_URL + "/user/{id}")
                .access("hasAnyRole('ROLE_ADMIN')")


                //sample request end-points

                .antMatchers(HttpMethod.POST, ApplicationConstant.API_BASE_URL + "/request")
                .access("hasAnyRole('ROLE_BUYER')")

                .antMatchers(HttpMethod.GET, ApplicationConstant.API_BASE_URL + "/request/{id}")
                .access("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_SAMPLE_ROOM_EMPLOYEE')")

                .antMatchers(HttpMethod.PUT, ApplicationConstant.API_BASE_URL + "/request/manager-check")
                .access("hasAnyRole('ROLE_MANAGER')")

                .antMatchers(HttpMethod.PUT, ApplicationConstant.API_BASE_URL + "/request/sampleroom-check")
                .access("hasAnyRole('ROLE_SAMPLE_ROOM_EMPLOYEE')")

                .antMatchers(HttpMethod.GET, ApplicationConstant.API_BASE_URL + "/request")
                .access("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_SAMPLE_ROOM_EMPLOYEE','ROLE_BUYER')")

                .and()
                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
