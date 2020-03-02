package com.maoz.app.genreport.modules.dashboard.controller;

import com.maoz.app.genreport.modules.dashboard.dao.CkReportDao;
import com.maoz.app.genreport.modules.core.MessageEnum;
import com.maoz.app.genreport.modules.core.entity.Report;
import com.maoz.app.genreport.modules.core.model.ApiResponse;
import com.maoz.app.genreport.modules.dashboard.model.ReportBean;
import com.maoz.app.genreport.modules.dashboard.model.ReportStructureBean;
import com.maoz.app.genreport.modules.dashboard.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dashboard/api")
@RestController
@Scope("request")
@Slf4j
public class DashboardRestController {

    private DashboardService dashboardService;

    public DashboardRestController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @CrossOrigin("*")
    @GetMapping("/report-list")
    public ApiResponse<List<ReportBean>> getReportList(){

        List<ReportBean> reports = this.dashboardService.getReportList();

        return new ApiResponse<>(reports, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @CrossOrigin("*")
    @GetMapping("/report-structure-list/{reportId}")
    public ApiResponse<List<ReportStructureBean>> getReportStructureList(@PathVariable Long reportId){

        List<ReportStructureBean> reportStructureBeans = this.dashboardService.getReportStructureByReportId(reportId);

        return new ApiResponse<>(reportStructureBeans, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

}
