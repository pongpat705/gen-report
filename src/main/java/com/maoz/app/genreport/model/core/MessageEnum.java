package com.maoz.app.genreport.model.core;

import lombok.Getter;

@Getter
public enum MessageEnum {
    OK("OK", "00")
    ;

    private String message;
    private String code;

    MessageEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
