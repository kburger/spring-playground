package com.github.kburger.playground.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationManager implements AuthenticationManager {
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationManager.class);
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("authentication in manager, {}", authentication);
        
        CustomToken token = (CustomToken)authentication;
        
        // check whether the token is known
        if (!TmpTokenCache.validateToken(token.getToken())) {
            throw new AuthenticationServiceException("invalid token");
        }
        
        // TODO check whether it is still valid, or the token has expired
            // TODO if it is not expired, refresh the expiration
        
        // TODO log the accessed call
        
        return authentication;
    }
}
