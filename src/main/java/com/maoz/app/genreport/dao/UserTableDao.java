package com.maoz.app.genreport.dao;

import com.maoz.app.genreport.aop.LogExecutionTime;
import com.maoz.app.genreport.model.core.entity.UserTable;
import com.maoz.app.genreport.utils.SnakeCaseRowMapperReflectImpl;
import com.maoz.app.genreport.utils.UserTableRowMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
@Scope("request" )
public class UserTableDao {

    private JdbcTemplate jdbcTemplate;

    public UserTableDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @LogExecutionTime
    @Transactional
    public List<UserTable> findAllTableNames(){
        StringBuilder sb = new StringBuilder();

        sb.append("select TABLESPACE_NAME, TABLE_NAME ");
        sb.append("from USER_TABLES ");

        log.info("sql for findAllTableNames : {}", sb.toString());
        log.info(jdbcTemplate.toString());
        List<UserTable> tableNames = jdbcTemplate.query(sb.toString(), new SnakeCaseRowMapperReflectImpl<>(UserTable.class));
        log.info("data {}", tableNames.toString());

        return  tableNames;
    }

    @LogExecutionTime
    @Transactional
    public List<UserTable> findAllTableNamesByMap(){
        StringBuilder sb = new StringBuilder();

        sb.append("select TABLESPACE_NAME as tableSpaceName, TABLE_NAME as tableName ");
        sb.append("from USER_TABLES ");

        log.info("sql for findAllTableNames : {}", sb.toString());
        log.info(jdbcTemplate.toString());
        List<UserTable> tableNames = jdbcTemplate.query(sb.toString(), new UserTableRowMapperImpl());
        log.info("data {}", tableNames.toString());

        return  tableNames;
    }
}
