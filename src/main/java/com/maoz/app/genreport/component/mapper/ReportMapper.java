package com.maoz.app.genreport.component.mapper;

import com.maoz.app.genreport.modules.core.entity.Report;
import com.maoz.app.genreport.modules.dashboard.model.ReportBean;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    ReportBean reportToReportBean(Report report);

    List<ReportBean> reportsToReportBeans(List<Report> reports);
}
