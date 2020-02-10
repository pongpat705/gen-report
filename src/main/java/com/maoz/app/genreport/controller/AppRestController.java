package com.maoz.app.genreport.controller;

import com.maoz.app.genreport.dao.BaseDao;
import com.maoz.app.genreport.dao.UserTableDao;
import com.maoz.app.genreport.model.core.UserTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class AppRestController {

    private UserTableDao userTableDao;

    @PostConstruct
    public void afterInit(){
        this.userTableDao = new UserTableDao();
    }

    @GetMapping(value = "/list/table")
    public List<UserTable> listTable(){
        List<UserTable> tableNames = this.userTableDao.findAllTableNames();
        return tableNames;
    }
}
