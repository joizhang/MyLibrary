package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.model.vo.Pager;
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
    public String addBook(@RequestBody Book book) {

        logger.info("1 {}",ReflectionToStringBuilder.toString(book));
        if (bookService.addBook(book)) {
            return "success";
        } else {
            return "fail";
        }
    }

    /* 获得列表 */
    @RequestMapping(value = "/bookList", method = RequestMethod.POST)
    @ResponseBody
    public Pager<Book> bookList(HttpServletRequest request) {
        Pager<Book> pager = new Pager<Book>();

        String currentPage =  WebUtils.getCleanParam(request, "currentPage");
        String pageSize = WebUtils.getCleanParam(request, "itemsPerPages");
        String search = WebUtils.getCleanParam(request, "search");
        System.out.println(pageSize +" --- "+ currentPage);

        if(currentPage != null){
            pager.setCurrentPage(Integer.parseInt(currentPage));
        } else {
            pager.setCurrentPage(1);
        }

        if(pageSize != null){
            pager.setPageSize(Integer.parseInt(pageSize));
        } else {
            pager.setPageSize(5);
        }

        pager = bookService.getBookList(pager, search);
        System.out.println(ReflectionToStringBuilder.toString(pager));
        return pager;
    }
}
