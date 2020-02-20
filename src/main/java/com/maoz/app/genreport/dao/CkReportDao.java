package com.maoz.app.genreport.dao;

import com.maoz.app.genreport.model.core.Report;
import com.maoz.app.genreport.utils.RowMapperReflectImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@Scope("request" )
public class CkReportDao {

    private JdbcTemplate jdbcTemplate;

    public CkReportDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Report> findAllReport(){
        StringBuilder sb = new StringBuilder();

        sb.append("select REPORT_ID as reportId, REPORT_NAME as reportName, REPORT_QUERY as reportQuery ");
        sb.append("from CK_REPORT ");

        log.info("sql for findAllReport : {}", sb.toString());

        List<Report> tableNames = jdbcTemplate.query(sb.toString(), new RowMapperReflectImpl<Report>(Report.class));
        log.info("data {}", tableNames.toString());

        return  tableNames;
    }

}
