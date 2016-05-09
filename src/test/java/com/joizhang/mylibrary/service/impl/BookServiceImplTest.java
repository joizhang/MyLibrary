package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.model.po.TBook;
import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.service.IBookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/5/4.
 */
/**
 * AbstractTransactionalJUnit4SpringContextTests : 会roolback
 * AbstractJUnit4SpringContextTests : 直接提交
 * */
@ContextConfiguration(locations = {"classpath*:/spring*.xml"})
public class BookServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private IBookService bookService;

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book();
        book.setBookNumber("1212");
        book.setBookName("请问请问");
        book.setBookType("1212");
        book.setDescription("1111");
        book.setSellAddress("http://127.0.0.1:3000/#/main/addBook");

        bookService.addBook(book);

        System.exit(0);
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