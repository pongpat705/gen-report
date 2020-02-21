package com.maoz.app.genreport.model.response;

import lombok.Data;

@Data
public class ReportBean {
    private Long reportId;
    private String reportName;
    private String reportQuery;
}
