package com.maoz.app.genreport.controller;

import com.maoz.app.genreport.dao.UserTableDao;
import com.maoz.app.genreport.model.core.UserTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request")
@Slf4j
public class AppRestController {


    private UserTableDao userTableDao;

    public AppRestController(UserTableDao userTableDao) {
        this.userTableDao = userTableDao;
    }

    @GetMapping(value = "/list/table/ref")
    public List<UserTable> listTableReflect(){
        log.info(this.toString());
        List<UserTable> tableNames = this.userTableDao.findAllTableNames();
        return tableNames;
    }

    @GetMapping(value = "/list/table/map")
    public List<UserTable> listTableMap(){
        log.info(this.toString());
        List<UserTable> tableNames = this.userTableDao.findAllTableNamesByMap();
        return tableNames;
    }
}
