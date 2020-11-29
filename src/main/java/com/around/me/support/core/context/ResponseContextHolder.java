package com.around.me.support.core.context;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class ResponseContextHolder {

    private final RestTemplate restTemplate;

    private static UserContextHolder userContextHolder;

    private static String xAuthToken;

    private static String refreshToken;

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
     * @param accessToken
     */
    public static void xAuthToken(String accessToken) {
        ResponseContextHolder.xAuthToken = accessToken;
    }

    /**
     * Get AccessToken
     *
     * @return
     */
    public static String xAuthToken() {
        return ResponseContextHolder.xAuthToken;
    }
}
