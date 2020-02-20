package com.maoz.app.genreport.controller;

import com.maoz.app.genreport.dao.UserTableDao;
import com.maoz.app.genreport.model.core.UserTable;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request" )
public class AppRestController {


    private UserTableDao userTableDao;

    public AppRestController(UserTableDao userTableDao) {
        this.userTableDao = userTableDao;
    }

    @GetMapping(value = "/list/table")
    public List<UserTable> listTable(){
        List<UserTable> tableNames = this.userTableDao.findAllTableNames();
        return tableNames;
    }
}
