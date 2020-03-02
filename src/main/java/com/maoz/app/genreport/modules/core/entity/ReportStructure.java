package com.maoz.app.genreport.modules.core.entity;

import lombok.Data;

@Data
public class ReportStructure {
    private Long structureId;
    private Long reportId;
    private Integer fieldNo;
    private String fieldName;
    private String fieldType;
    private Integer fieldSize;
    private Integer fieldScale;
    private String fieldNullable;
}
