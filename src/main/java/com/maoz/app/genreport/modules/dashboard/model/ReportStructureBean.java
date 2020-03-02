package com.maoz.app.genreport.modules.dashboard.model;

import lombok.Data;

@Data
public class ReportStructureBean {
    private Long structureId;
    private Long reportId;
    private Integer fieldNo;
    private String fieldName;
    private String fieldType;
    private Integer fieldSize;
    private Integer fieldScale;
    private String fieldNullable;
}
