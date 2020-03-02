package com.maoz.app.genreport.modules.dashboard.service;

import com.maoz.app.genreport.component.mapper.ReportMapper;
import com.maoz.app.genreport.component.mapper.ReportStructureMapper;
import com.maoz.app.genreport.modules.core.entity.Report;
import com.maoz.app.genreport.modules.core.entity.ReportStructure;
import com.maoz.app.genreport.modules.dashboard.dao.CkReportDao;
import com.maoz.app.genreport.modules.dashboard.model.ReportBean;
import com.maoz.app.genreport.modules.dashboard.model.ReportStructureBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    public List<ReportStructureBean> getReportStructureByReportId(Long reportId) {
        log.info("getReportStructureByReportId {}", reportId);
        List<ReportStructure> reportStructureList = this.ckReportDao.findAllReportStructureByReportId(reportId);

        List<ReportStructureBean> result = ReportStructureMapper.INSTANCE.reportStructuresToReportStructureBeans(reportStructureList);

        return result;
    }
}
