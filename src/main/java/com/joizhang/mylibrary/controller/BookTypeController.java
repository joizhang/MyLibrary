package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.model.vo.BookType;
import com.joizhang.mylibrary.service.IBookTypeService;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
@Controller
@RequestMapping("/bookType")
public class BookTypeController {

    @Autowired
    private IBookTypeService bookTypeService;

    @RequestMapping(value = "/getAllBookType", method = RequestMethod.GET)
    @ResponseBody
    public List<BookType> getAllBookType() {
        return bookTypeService.getAllBookTypes();
    }

    @RequestMapping(value = "/getBookType", method = RequestMethod.GET)
    @ResponseBody
    public BookType getBookType(HttpServletRequest request) {
        String bookType = WebUtils.getCleanParam(request, "bookType");
        return bookTypeService.getBookType(bookType);
    }

}
