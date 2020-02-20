package com.maoz.app.genreport.utils;


import com.maoz.app.genreport.model.core.UserTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


@Slf4j
public class UserTableRowMapperImpl implements RowMapper<UserTable> {

    @Override
    public UserTable mapRow(ResultSet resultSet, int i) throws SQLException {
        UserTable result = new UserTable();
        result.setTableName(resultSet.getString("TABLE_NAME"));
        result.setTablespaceName(resultSet.getString("TABLESPACE_NAME"));
        return result;
    }
}
