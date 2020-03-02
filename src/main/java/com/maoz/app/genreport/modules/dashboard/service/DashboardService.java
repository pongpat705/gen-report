package com.maoz.app.genreport.modules.dashboard.service;

import com.maoz.app.genreport.component.mapper.ReportMapper;
import com.maoz.app.genreport.modules.core.entity.Report;
import com.maoz.app.genreport.modules.dashboard.dao.CkReportDao;
import com.maoz.app.genreport.modules.dashboard.model.ReportBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("request")
public class DashboardService {

    private CkReportDao ckReportDao;

    public DashboardService(CkReportDao ckReportDao) {
        this.ckReportDao = ckReportDao;
    }

    public List<ReportBean> getReportList() {
        List<Report> reports = this.ckReportDao.findAllReport();

        List<ReportBean> results = ReportMapper.INSTANCE.reportsToReportBeans(reports);

        return results;
    }
}
