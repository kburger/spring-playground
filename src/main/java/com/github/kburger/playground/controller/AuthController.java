package com.github.kburger.playground.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.kburger.playground.domain.CustomTokenResponse;
import com.github.kburger.playground.security.TmpTokenCache;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public CustomTokenResponse authToken() {
        String token = Integer.toString(this.hashCode());
        TmpTokenCache.registerToken(token);
        return new CustomTokenResponse(token);
    }
}
