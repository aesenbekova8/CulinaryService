package com.example.CulinaryService.utils;

public class Response {
    private String message;

    private boolean isSuccess;

    private Object data;

    public Response(String message, boolean isSuccess, Object data) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.data = data;
    }
}
