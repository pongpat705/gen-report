package com.maoz.app.genreport.modules.core;

import lombok.Getter;

@Getter
public enum MessageEnum {
    OK("OK", "00"),
    NOTFOUND("NOT_FOUND", "01"),
    BAD("BAD", "01")
    ;

    private String message;
    private String code;

    MessageEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
