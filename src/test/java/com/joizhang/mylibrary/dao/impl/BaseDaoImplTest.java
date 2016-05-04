package com.joizhang.mylibrary.dao.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.TBook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/5/4.
 */
@ContextConfiguration(locations = {"classpath*:/spring*.xml"})
public class BaseDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IBaseDao<TBook> bookIBaseDao;

    @Test
    public void testGet() throws Exception {
        String bookId = "011a5762-281c-4c1d-ae40-810190ee2d0b";
        TBook tBook = new TBook();
        tBook = bookIBaseDao.get(TBook.class, bookId);
        System.out.println(tBook);
    }

}