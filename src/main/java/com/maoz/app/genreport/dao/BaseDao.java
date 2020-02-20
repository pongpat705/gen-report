package com.maoz.app.genreport.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Repository
@Scope("request" )
public class BaseDao {

    public JdbcTemplate jdbcTemplate;

    public BaseDao() {
        jdbcTemplate = new JdbcTemplate(this.getDataSource());
    }

    public DataSource getDataSource() {
        log.info("getting DataSource {}", this.getClass().getName());
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@172.104.45.225:1521:TEST01");
        dataSource.setUsername("ck_dev");
        dataSource.setPassword("ckpassword");

        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = this.jdbcTemplate.getDataSource().getConnection();
        return connection;
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
