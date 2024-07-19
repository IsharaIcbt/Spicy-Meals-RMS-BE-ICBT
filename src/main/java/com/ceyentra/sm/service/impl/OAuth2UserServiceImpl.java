/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 3:29 PM
 */
package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.entity.UserEntity;
import com.ceyentra.sm.exception.CustomOauthException;
import com.ceyentra.sm.repository.UserRepository;
import com.ceyentra.sm.service.OAuth2UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
@Log4j2
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OAuth2UserServiceImpl implements OAuth2UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public OAuth2UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("starting function loadUserByUsername @Param username : {}", username);
        try {

            Optional<UserEntity> byEmail = userRepository.findByEmail(username);

            if (!byEmail.isPresent())
                throw new CustomOauthException("Invalid Credentials.");

            UserEntity user = byEmail.get();
            log.info("Issuing tokens for user with username : {} password : {}", user.getEmail(), user.getPassword());
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(), getAuthority(user.getUserRole().name())
            );

        } catch (Exception e) {
            log.error("function loadUserByUsername {}", e.getMessage(), e);
            throw e;
        }
    }

    private List<SimpleGrantedAuthority> getAuthority(String roleName) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));
    }

}
