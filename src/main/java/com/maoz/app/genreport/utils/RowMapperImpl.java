package com.maoz.app.genreport.utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Slf4j
@NoArgsConstructor
public class RowMapperImpl<T> implements RowMapper<T> {
    private Class<T> clazzOfT;
    public T getInstance() throws Exception {
        return clazzOfT.getDeclaredConstructor().newInstance();
    }

    public RowMapperImpl(Class<T> clazzOfT) {
        this.clazzOfT = clazzOfT;
    }


    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        T result = null;
        try {
            result = this.getInstance();
            log.info("mapper for {}", result.getClass().getName());
            Field[] fields = result.getClass().getDeclaredFields();
            log.info("fields size {}", fields.length);
            for (Field f : fields) {
                f.setAccessible(true);
                log.info("field name {} type {}", f.getName(), f.getType().getName());
                Object xValue = null;
                if(f.getType() == Long.class){
                    xValue = resultSet.getLong(f.getName());
                } else if(f.getType() == String.class){
                    xValue = resultSet.getString(f.getName());
                } else if(f.getType() == Integer.class){
                    xValue = resultSet.getInt(f.getName());
                } else if(f.getType() == BigDecimal.class){
                    xValue = resultSet.getBigDecimal(f.getName());
                } else if(f.getType() == Double.class){
                    xValue = resultSet.getDouble(f.getName());
                } else if(f.getType() == Date.class){
                    java.sql.Date xDate = resultSet.getDate(f.getName());
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
