package com.around.me.support.core.context;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResponseContextHolder {

    private static UserContextHolder userContextHolder;

    private static String xAuthToken;

    private static String xRefreshToken;

    /**
     * Get User
     *
     * @return
     */
    public static UserContextHolder user() {
        return ResponseContextHolder.userContextHolder;
    }

    /**
     * Set User
     *
     * @param userContextHolder
     */
    public static void user(UserContextHolder userContextHolder) {
        ResponseContextHolder.userContextHolder = userContextHolder;
    }

    /**
     * Set AccessToken
     *
     * @param xAuthToken
     */
    public static void xAuthToken(String xAuthToken) {
        ResponseContextHolder.xAuthToken = xAuthToken;
    }

    /**
     * Set AccessToken
     *
     * @param xRefreshToken
     */
    public static void xRefreshToken(String xRefreshToken) {
        ResponseContextHolder.xRefreshToken = xRefreshToken;
    }

    /**
     * Get AccessToken
     *
     * @return
     */
    public static String xAuthToken() {
        return ResponseContextHolder.xAuthToken;
    }

    /**
     * Get RefreshToken
     *
     * @return
     */
    public static String xRefreshToken() {
        return ResponseContextHolder.xRefreshToken;
    }
}
