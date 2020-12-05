package com.around.me.support.core.dto;

import com.around.me.support.core.support.HttpHeaderBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class Response<T> {

    @JsonProperty("status")
    private int status;

    @JsonProperty("code")
    private int code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("content")
    private T content;

    protected Response(int status, int code, String message, T content) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Response<T> of(int status, int code, String message, T content) {

        return new Response<>(status, code, message, content);
    }

    public static <T> Response<T> of(int status, int code, String message) {

        return of(status, code, message, null);
    }

    public static <T> Response<T> ok(int code, String message, T content) {

        return of(HttpStatus.OK.value(), code, message, content);
    }

    public static <T> Response<T> ok(int code,T content) {

        return of(HttpStatus.OK.value(), code, HttpStatus.OK.getReasonPhrase(), content);
    }

    public static <T> Response<T> badRequest(int code, T content) {

        return badRequest(code, HttpStatus.BAD_REQUEST.getReasonPhrase(), content);
    }

    public static <T> Response<T> badRequest(int code, String message, T content) {

        return of(HttpStatus.BAD_REQUEST.value(), code, message, content);
    }

    public static <T> Response<T> error(int code, String message, T content) {

        return of(HttpStatus.INTERNAL_SERVER_ERROR.value(), code, message, content);
    }

    public static <T> Response<T> error(int code, T content) {

        return error(code, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), content);
    }

    public int getStatus() {
        return status;
    }

    public int getCode() {
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
