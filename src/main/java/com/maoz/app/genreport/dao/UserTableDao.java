package com.maoz.app.genreport.dao;

import com.maoz.app.genreport.model.core.UserTable;
import com.maoz.app.genreport.utils.RowMapperImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserTableDao extends BaseDao {


    public List<UserTable> findAllTableNames(){
        StringBuilder sb = new StringBuilder();

        sb.append("select TABLESPACE_NAME as tableSpaceName, TABLE_NAME as tableName ");
        sb.append("from USER_TABLES ");

        log.info("sql for findAllTableNames : {}", sb.toString());

        List<UserTable> tableNames = jdbcTemplate.query(sb.toString(), new RowMapperImpl<UserTable>(UserTable.class));
        log.info("data {}", tableNames.toString());

        return  tableNames;
    }
}
