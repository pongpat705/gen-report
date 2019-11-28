package com.maoz.app.genreport.controller;

import com.maoz.app.genreport.dao.BaseDao;
import com.maoz.app.genreport.model.core.TableModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppRestController {

    private BaseDao baseDao;

    public AppRestController(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @GetMapping(value = "/list/table")
    public List<TableModel> listTable(){
        List<TableModel> tableNames = this.baseDao.findAllTableNames();
        return tableNames;
    }
}
