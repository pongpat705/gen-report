package com.maoz.app.genreport.utils;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperConfImpl<T> implements RowMapper<T> {

    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
