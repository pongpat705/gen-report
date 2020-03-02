package com.maoz.app.genreport.modules.core.model;
import lombok.Data;

import java.util.Date;

@Data
public class ApiResponse<T> {

    private Date timeStamp;
    private String message;
    private Integer code;
    private T data;

    public ApiResponse(Integer code, String message) {
        this.timeStamp = new Date();
        this.data = null;
        this.code = code;
        this.message = message;
    }

    public ApiResponse(T data, Integer code, String message) {
        this.timeStamp = new Date();
        this.data = data;
        this.code = code;
        this.message = message;
    }
}
