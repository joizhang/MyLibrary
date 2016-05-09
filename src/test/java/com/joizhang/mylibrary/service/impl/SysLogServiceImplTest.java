package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.model.po.TBook;
import com.joizhang.mylibrary.service.ISysLogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/5/9.
 */
@ContextConfiguration(locations = {"classpath*:/spring*.xml"})
public class SysLogServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ISysLogService sysLogService;

    @Test
    public void testSaveSysLog() throws Exception {
        TBook tBook = new TBook(
                "123",
                "123",
                "123",
                "app/images/default-avatar.jpg",
                new Timestamp(System.currentTimeMillis()),
                "111111111111",
                0,
                new Timestamp(System.currentTimeMillis()),
                "1111111",
                "https://www.sogou.com/",
                "web"
                );
        sysLogService.saveSysLog(tBook, ISysLogService.CREATE);
    }
}