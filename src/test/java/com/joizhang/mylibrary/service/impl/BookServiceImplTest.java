package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.service.IBookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/5/4.
 */
@ContextConfiguration(locations = {"classpath*:/spring*.xml"})
public class BookServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IBookService bookService;

    @Test
    public void testAddBook() throws Exception {

    }

    @Test
    public void testGetBookList() throws Exception {

    }

    @Test
    public void testDeleteBook() throws Exception {
        String bookId = "f122df83-8c9b-42bd-bbe6-dc3c088da660";
        bookService.deleteBook(bookId);
    }

    @Test
    public void testCut() {
        System.out.println("day.png".substring(0, "day.png".indexOf(".")));
    }

    @Test
    public void testUpdatePhotoPath() {
        String photoFolder = "app/images/";
        String uploadFileFileName = "1212.jpg";
        bookService.updatePhotoPath(photoFolder, uploadFileFileName);
    }
}