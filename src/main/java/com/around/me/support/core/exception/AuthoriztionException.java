package com.around.me.support.core.exception;

import com.around.me.support.core.enums.response.ResponseCodeEnum;

import java.io.Serializable;

/**
 * 권한에러
 */
public class AuthoriztionException extends RuntimeException implements Serializable {

    private String code = ResponseCodeEnum.NONE_AUTH.code();
    private String message = ResponseCodeEnum.NONE_AUTH.message();

    public AuthoriztionException() {
        super();
    }

    public AuthoriztionException(String message) {
        super(message);
    }

    public AuthoriztionException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthoriztionException(Throwable cause) {
        super(cause);
    }

    public AuthoriztionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AuthoriztionException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
