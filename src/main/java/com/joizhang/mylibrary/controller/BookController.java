package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/4/22.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    /*添加新图书*/
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public void addBook(Book book) {
        logger.debug("{}",book);

    }
}