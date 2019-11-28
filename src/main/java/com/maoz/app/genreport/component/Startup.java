package com.maoz.app.genreport.component;

import com.maoz.app.genreport.dao.BaseDao;
import com.maoz.app.genreport.model.core.TableModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Startup {

    private BaseDao baseDao;

    @PostConstruct
    public void afterInit(){
        this.baseDao = new BaseDao();
        List<TableModel> tableNames = this.baseDao.findAllTableNames();
    }


}
