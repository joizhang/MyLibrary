package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.model.po.TBooktype;
import com.joizhang.mylibrary.model.vo.BookType;
import com.joizhang.mylibrary.service.IBookTypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by 新林 on 2016/5/9.
 */
@ContextConfiguration(locations = {"classpath*:/spring*.xml"})
public class BookTypeServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private IBookTypeService bookTypeService;

    @Test
    public void testSaveBookType() throws Exception {
        TBooktype tBooktype = new TBooktype();
        tBooktype.setBookType("1212");
        bookTypeService.saveBookType(tBooktype);

    }
}