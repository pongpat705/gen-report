package com.maoz.app.genreport.modules.dashboard.model;

import lombok.Data;

@Data
public class ReportBean {
    private Long reportId;
    private String reportName;
    private String reportQuery;
    private String reportType;
}
