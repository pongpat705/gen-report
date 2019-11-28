package com.maoz.app.genreport.dao;

import com.maoz.app.genreport.model.core.TableModel;
import com.maoz.app.genreport.utils.RowMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class BaseDao {

    private JdbcTemplate jdbcTemplate;

    public BaseDao() {
        jdbcTemplate = new JdbcTemplate(this.getDataSource());
    }

    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://172.104.45.225:5442/maoz");
        dataSource.setUsername("pongpat705");
        dataSource.setPassword("d6iydc8mot");

        return dataSource;
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

    @PreDestroy
    private void afterUsed(){
        try {
            log.info("closing connection!");
            this.jdbcTemplate.getDataSource().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
