package com.palettering.api.core.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import static javax.servlet.http.HttpServletResponse.SC_OK;

@Getter
@ToString
public class Response<T> {

    private int code;

    private String message;

    private T data;

    private Response() {
        this(null);
    }

    @Builder
    public Response(T data) {
        this.code = SC_OK;
        this.message = "SUCCESS";
        this.data = data;
    }

    public static Response ok() {
        return new Response();
    }
}
