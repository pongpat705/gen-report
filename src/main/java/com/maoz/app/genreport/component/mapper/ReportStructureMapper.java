package com.maoz.app.genreport.component.mapper;

import com.maoz.app.genreport.modules.core.entity.ReportStructure;
import com.maoz.app.genreport.modules.dashboard.model.ReportStructureBean;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReportStructureMapper {

    ReportStructureMapper INSTANCE = Mappers.getMapper(ReportStructureMapper.class);

    List<ReportStructureBean> reportStructuresToReportStructureBeans(List<ReportStructure> reportStructures);
}
