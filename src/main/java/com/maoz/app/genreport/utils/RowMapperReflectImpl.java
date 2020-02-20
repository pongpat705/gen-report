package com.maoz.app.genreport.utils;

import com.google.common.base.CaseFormat;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

@Slf4j
@NoArgsConstructor
public class RowMapperReflectImpl<T> implements RowMapper<T> {
    private Class<T> clazzOfT;
    public T getInstance() throws Exception {
        return clazzOfT.getDeclaredConstructor().newInstance();
    }

    public RowMapperReflectImpl(Class<T> clazzOfT) {
        this.clazzOfT = clazzOfT;
    }


    @Override
    public T mapRow(ResultSet resultSet, int i) {
        T result = null;
        try {
            ResultSetMetaData md = resultSet.getMetaData();
            int columnCount = md.getColumnCount();
            log.info("column count {}", columnCount);
            for (int j = 1; j < columnCount; j++) {
                String columnType = md.getColumnTypeName(j);
                log.info("columnType {} ", columnType);
                String columnName = md.getColumnName(j);
                log.info("columnName {} ", columnName);
            }
            result = this.getInstance();
            log.info("mapper for {}", result.getClass().getName());
            Field[] fields = result.getClass().getDeclaredFields();
            log.info("fields size {}", fields.length);
            for (int j = 0; j < fields.length; j++){
                Field f = fields[j];

                f.setAccessible(true);
                log.info("field name {} type {}", f.getName(), f.getType().getName());
                Object xValue = null;
                String k = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, f.getName());
                log.info("key : {}", k);
                if(f.getType() == Long.class){
                    xValue = resultSet.getLong(k);
                } else if(f.getType() == String.class){
                    xValue = resultSet.getString(k);
                } else if(f.getType() == Integer.class){
                    xValue = resultSet.getInt(k);
                } else if(f.getType() == BigDecimal.class){
                    xValue = resultSet.getBigDecimal(k);
                } else if(f.getType() == Double.class){
                    xValue = resultSet.getDouble(k);
                } else if(f.getType() == Date.class){
                    java.sql.Date xDate = resultSet.getDate(k);
                    xValue = new Date(xDate.getTime());
                }
                f.set(result, xValue);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
