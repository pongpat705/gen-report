package com.maoz.app.genreport.controller.api;

import com.maoz.app.genreport.dao.CkReportDao;
import com.maoz.app.genreport.model.core.MessageEnum;
import com.maoz.app.genreport.model.core.entity.Report;
import com.maoz.app.genreport.model.core.model.ApiResponse;
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
    private CkReportDao ckReportDao;

    public DashboardRestController(CkReportDao ckReportDao) {
        this.ckReportDao = ckReportDao;
    }

    @CrossOrigin("*")
    @GetMapping("/report-list")
    public ApiResponse<List<Report>> getReportList(){

        List<Report> reports = this.ckReportDao.findAllReport();

        return new ApiResponse<>(reports, MessageEnum.OK.getCode(), MessageEnum.OK.getMessage());
    }

}
