package com.maoz.app.genreport.modules.dashboard.controller;

import com.maoz.app.genreport.modules.dashboard.dao.CkReportDao;
import com.maoz.app.genreport.modules.core.MessageEnum;
import com.maoz.app.genreport.modules.core.entity.Report;
import com.maoz.app.genreport.modules.core.model.ApiResponse;
import com.maoz.app.genreport.modules.dashboard.model.ReportBean;
import com.maoz.app.genreport.modules.dashboard.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return new ApiResponse<>(reports, MessageEnum.OK.getCode(), MessageEnum.OK.getMessage());
    }

}
