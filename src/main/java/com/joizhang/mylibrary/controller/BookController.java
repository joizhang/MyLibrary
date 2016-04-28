package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.service.IBookService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/4/22.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    /*添加新图书*/
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> addBook(@RequestBody Book book) {

        logger.info("1 {}",ReflectionToStringBuilder.toString(book));
        String message = bookService.addBook(book);
        if (message.equals("error")) {
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

}
