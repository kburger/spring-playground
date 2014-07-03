package com.github.kburger.playground.security;

public class TmpTokenCache {
    private static String token;
    
    public static void registerToken(String token) {
        TmpTokenCache.token = token;
    }
    
    public static boolean validateToken(String token) {
        return token.equals(TmpTokenCache.token);
    }
}
