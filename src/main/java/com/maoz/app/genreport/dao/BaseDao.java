package com.maoz.app.genreport.dao;

import com.maoz.app.genreport.model.core.TableModel;
import com.maoz.app.genreport.utils.RowMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class BaseDao {

    private JdbcTemplate jdbcTemplate;

    public BaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TableModel> findAllTableNames(){
        StringBuilder sb = new StringBuilder();

        sb.append("select schemaname, tablename ");
        sb.append("from pg_tables ");
        sb.append("where schemaname = 'public' ");

        log.info("sql for findAllTableNames : {}", sb.toString());

        List<TableModel> tableNames = jdbcTemplate.query(sb.toString(), new RowMapperImpl<TableModel>(TableModel.class));
        log.info("data {}", tableNames.toString());

        return  tableNames;
    }
}
