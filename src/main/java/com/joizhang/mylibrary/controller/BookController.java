package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.model.vo.Pager;
import com.joizhang.mylibrary.service.IBookService;
import com.joizhang.mylibrary.utils.FileUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

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
    public Map<String, Object> addBook(@RequestBody Book book) {
        Map<String, Object> map = new HashedMap();
        //logger.info("1 {}",ReflectionToStringBuilder.toString(book));
        if (bookService.addBook(book)) {
            map.put("msg", "success");
        } else {
            map.put("msg", "fail");
        }
        return map;
    }

    /* 获得列表 */
    @RequestMapping(value = "/bookList", method = RequestMethod.POST)
    @ResponseBody
    public Pager<Book> bookList(HttpServletRequest request) {
        Pager<Book> pager = new Pager<Book>();

        String currentPage = WebUtils.getCleanParam(request, "currentPage");
        String pageSize = WebUtils.getCleanParam(request, "itemsPerPages");
        String search = WebUtils.getCleanParam(request, "search");
        //System.out.println(pageSize +" --- "+ currentPage);

        if (currentPage != null) {
            pager.setCurrentPage(Integer.parseInt(currentPage));
        } else {
            pager.setCurrentPage(1);
        }

        if (pageSize != null) {
            pager.setPageSize(Integer.parseInt(pageSize));
        } else {
            pager.setPageSize(5);
        }

        pager = bookService.getBookList(pager, search);
        //System.out.println(ReflectionToStringBuilder.toString(pager));
        return pager;
    }

    /* 删除图书 */
    @RequestMapping(value = "/deleteBook/{bookId}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteBook(@PathVariable String bookId) {
        Map<String, Object> map = new HashedMap();
        bookService.deleteBook(bookId);
        map.put("msg", "success");
        return map;
    }

    /* 上传图片 */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartHttpServletRequest request) {
        //logger.info("file upload");

        Map<String, Object> map = new HashedMap();

        Iterator<String> itr = request.getFileNames();
        //logger.info(ReflectionToStringBuilder.toString(itr));

        MultipartFile file = request.getFile(itr.next());
        //logger.info(ReflectionToStringBuilder.toString(file));

        if (!file.isEmpty()) {
            FileUtils fileUtils = new FileUtils();
            String realPath = request.getSession().getServletContext().getRealPath("/");
            //获取源文件名
            String uploadFileFileName = file.getOriginalFilename();
            //获取源文件类型
            String fileType = uploadFileFileName.substring(uploadFileFileName.lastIndexOf("."));

            //正式存放目录
            String photoFolder = realPath + "photos\\app\\images\\uploadedBook";

            try {
                File targetFile = new File(photoFolder, uploadFileFileName);
                //如果目标文件已存在，删除
                if (targetFile.exists()) {
                    targetFile.delete();
                } else {
                    fileUtils.creatFolder(photoFolder);
                }

                file.transferTo(targetFile);
                map.put("msg", "success");
                bookService.updatePhotoPath(targetFile.getPath(), uploadFileFileName);
            } catch (Exception e) {
                map.put("msg", "fail");
            }
        }

        return map;
    }

    @RequestMapping(value = "/lendBook", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> lendBook(HttpServletRequest request) {
        Map<String, Object> map = new HashedMap();

        String lendBookName = WebUtils.getCleanParam(request, "lendBookName");
        String lendBookNumber = WebUtils.getCleanParam(request, "lendBookNumber");
        String lendBookBorrower = WebUtils.getCleanParam(request, "lendBookBorrower");

        logger.info("lendBookName:" + lendBookName + " lendBookNumber:" + lendBookNumber + " lendBookBorrower" + lendBookBorrower);
        map.put("msg", "success");
        return map;
    }
}
