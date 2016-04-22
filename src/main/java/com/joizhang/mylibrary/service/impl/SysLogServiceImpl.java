package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.SysLog;
import com.joizhang.mylibrary.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;

/**
 * Created by Administrator on 2016/4/22.
 */
@Service("logService")
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private IBaseDao<SysLog> logDAO;

    public void saveSysLog(Object o, int type) {
        String sql = null;

        //1、获取到class
        Class c = o.getClass();

        //2、获取到table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if (exists) {
            switch (type) {
                case 1:
                    sql = sqlWithCreateType(c);
                    break;
                case 2:
                    sql = sqlWithRetrieveType(c);
            }
        }
    }

    /*新增的SQL*/
    public String sqlWithCreateType(Class c) {
        StringBuffer sbf = new StringBuffer();

        return sbf.toString();
    }

    /*重新获取的SQL*/
    public String sqlWithRetrieveType(Class c) {
        StringBuffer sbf = new StringBuffer();

        return sbf.toString();
    }

    /*更新的SQL*/
    public String sqlWithUpdateType(Class c) {
        StringBuffer sbf = new StringBuffer();

        return sbf.toString();
    }

    /*删除的SQL*/
    public String sqlWithDeleteType(Class c) {
        StringBuffer sbf = new StringBuffer();

        return sbf.toString();
    }
}
