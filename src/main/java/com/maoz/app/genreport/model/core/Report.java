package com.maoz.app.genreport.model.core;

import lombok.Data;

@Data
public class Report {
    private Long reportId;
    private String reportName;
    private String reportQuery;
}
