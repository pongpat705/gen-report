package com.maoz.app.genreport.dao;

import com.maoz.app.genreport.model.core.Report;
import com.maoz.app.genreport.model.core.UserTable;
import com.maoz.app.genreport.utils.RowMapperImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CkReportDao extends BaseDao {

    public List<Report> findAllReport(){
        StringBuilder sb = new StringBuilder();

        sb.append("select REPORT_ID as reportId, REPORT_NAME as reportName, REPORT_QUERY as reportQuery ");
        sb.append("from CK_REPORT ");

        log.info("sql for findAllReport : {}", sb.toString());

        List<Report> tableNames = jdbcTemplate.query(sb.toString(), new RowMapperImpl<Report>(Report.class));
        log.info("data {}", tableNames.toString());

        return  tableNames;
    }

}
