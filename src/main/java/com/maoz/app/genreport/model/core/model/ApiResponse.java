package com.maoz.app.genreport.model.core.model;
import lombok.Data;

@Data
public class ApiResponse<T> {

    private String message;
    private String code;
    private T data;

    public ApiResponse(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
}
