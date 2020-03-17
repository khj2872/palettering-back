package com.palettering.api.palettering.model;

import lombok.Data;

import static javax.servlet.http.HttpServletResponse.SC_OK;

@Data
public class Response<T> {

    private int code;

    private String message;

    private T data;

    private Response() {
        this(null);
    }

    public Response(T data) {
        this.code = SC_OK;
        this.message = "SUCCESS";
        this.data = data;
    }

    public static Response ok() {
        return new Response();
    }
}
