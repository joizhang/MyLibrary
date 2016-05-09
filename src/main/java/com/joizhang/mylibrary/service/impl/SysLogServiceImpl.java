package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.SysLog;
import com.joizhang.mylibrary.service.ISysLogService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/22.
 */


@Service("logService")
public class SysLogServiceImpl implements ISysLogService {

    private static final Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);
    @Autowired
    private IBaseDao<SysLog> logDAO;

    /**
     * static final int CREATE = 1;
     * static final int RETRIEVE = 2;
     * static final int UPDATE = 3;
     * static final int DELETE = 4;
     */
    public void saveSysLog(Object o, int type) {
        String sql = null;

        //1、获取到class
        Class c = o.getClass();

        boolean exists = c.isAnnotationPresent(Table.class);
        SysLog sysLog = new SysLog();
        sysLog.setLogId(UUID.randomUUID().toString());
        sysLog.setOperateMan("admin");
        sysLog.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.name();
        sysLog.setOperateTable(tableName);
        if (exists) {
            switch (type) {
                case 1:
                    sql = sqlWithCreateType(o);
                    sysLog.setContent("新增【" + sql + "】");
                    logDAO.save(sysLog);
                    break;
                case 2:
                    sql = sqlWithRetrieveType(o);
                    break;
                case 3:
                    sql = sqlWithUpdateType(o);
                    break;
                case 4:
                    sql = sqlWithDeleteType(o);
            }
        }

    }

    /*新增的SQL*/
    public String sqlWithCreateType(Object o) {
        StringBuffer sbf = new StringBuffer();
        StringBuffer columnNameSbf = new StringBuffer();
        StringBuffer columnValueSbf = new StringBuffer();

        //1、获取到class
        Class c = o.getClass();

        boolean exists = c.isAnnotationPresent(Table.class);
        if(!exists) {
            return null;
        }

        //2、获取到table的名字
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.name();
        sbf.append("insert into ").append(tableName);
        columnNameSbf.append(" (");
        columnValueSbf.append(" values (");

        //3、拿到所有的字段
        Field[] fArray = c.getDeclaredFields();

        //4、拿到所有的方法
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            //5、拼接SQL
            //5.1、拿到字段名
            boolean mExists = method.isAnnotationPresent(Column.class);
            if (!mExists) {
                continue;
            }
            Column column = method.getAnnotation(Column.class);
            String columnName = column.name();
            //5.2、拿到字段的值
            Object fieldValue = null;
            //System.out.println(method);
            try {
                fieldValue = method.invoke(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //System.out.println(fieldValue);
            //5.3、拼装sql
            if(fieldValue == null) {
                continue;
            }

            columnNameSbf.append(columnName).append(",");

            if (fieldValue instanceof String || fieldValue instanceof Timestamp) {
                columnValueSbf.append("'").append(fieldValue).append("',");
            } else if (fieldValue instanceof Integer) {
                columnValueSbf.append(fieldValue).append(",");
            }
        }

        columnNameSbf.deleteCharAt(columnNameSbf.length()-1);
        columnNameSbf.append(")");
        columnValueSbf.deleteCharAt(columnValueSbf.length()-1);
        columnValueSbf.append(")");
//        System.out.println("\n" + columnNameSbf);
//        System.out.println(columnValueSbf);
        sbf.append(columnNameSbf).append(columnValueSbf);
//        System.out.println(sbf);
        return sbf.toString();
    }

    /*重新获取的SQL*/
    public String sqlWithRetrieveType(Object o) {
        StringBuffer sbf = new StringBuffer();

        return sbf.toString();
    }

    /*更新的SQL*/
    public String sqlWithUpdateType(Object o) {
        StringBuffer sbf = new StringBuffer();

        return sbf.toString();
    }

    /*删除的SQL*/
    public String sqlWithDeleteType(Object o) {
        StringBuffer sbf = new StringBuffer();

        return sbf.toString();
    }
}
