package com.maoz.app.genreport.component;

import com.maoz.app.genreport.dao.BaseDao;
import com.maoz.app.genreport.dao.UserTableDao;
import com.maoz.app.genreport.model.core.UserTable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Startup {

    private UserTableDao userTableDao;

    @PostConstruct
    public void afterInit(){
        this.userTableDao = new UserTableDao();
        List<UserTable> tableNames = this.userTableDao.findAllTableNames();
    }


}
