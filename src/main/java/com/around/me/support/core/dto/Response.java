package com.around.me.support.core.dto;

import com.around.me.support.core.enums.response.ResponseCodeEnum;
import com.around.me.support.core.support.HttpHeaderBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class Response<T> {

    @JsonProperty("status")
    private int status;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("content")
    private T content;

    protected Response(int status, String code, String message, T content) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Response<T> of(int status, String code, String message, T content) {

        return new Response<>(status, code, message, content);
    }

    public static <T> Response<T> of(int status, String code, String message) {

        return of(status, code, message, null);
    }

    public static <T> Response<T> ok(T content) {

        return of(HttpStatus.OK.value(), ResponseCodeEnum.OK.code(), ResponseCodeEnum.OK.message(), content);
    }

    public static <T> Response<T> ok(String message, T content) {

        return of(HttpStatus.OK.value(), ResponseCodeEnum.OK.code(), message, content);
    }

    public static <T> Response<T> ok(String code, String message, T content) {

        return of(HttpStatus.OK.value(), code, message, content);
    }

    public static <T> Response<T> badRequest(String code, T content) {

        return badRequest(code, HttpStatus.BAD_REQUEST.getReasonPhrase(), content);
    }

    public static <T> Response<T> badRequest(String code, String message, T content) {

        return of(HttpStatus.BAD_REQUEST.value(), code, message, content);
    }

    public static <T> Response<T> error(String code, String message, T content) {

        return of(HttpStatus.INTERNAL_SERVER_ERROR.value(), code, message, content);
    }

    public static <T> Response<T> error(String code, T content) {

        return error(code, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), content);
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public T getContent() {
        return content;
    }
}
