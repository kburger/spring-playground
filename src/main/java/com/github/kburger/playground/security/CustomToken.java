package com.github.kburger.playground.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class CustomToken extends AbstractAuthenticationToken {
    private String token;
    
    public CustomToken(String token) {
        super(null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
    @Override
    public Object getCredentials() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        return null;
    }
}
