package com.maoz.app.genreport.modules.core.entity;

import lombok.Data;

@Data
public class Report {
    private Long reportId;
    private String reportName;
    private String reportQuery;
    private String reportType;
}
