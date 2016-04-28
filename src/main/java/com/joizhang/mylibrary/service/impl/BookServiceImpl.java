package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.SysLog;
import com.joizhang.mylibrary.model.po.TBook;
import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.service.IBookService;
import com.joizhang.mylibrary.service.ISysLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/22.
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {



    @Autowired
    private IBaseDao<TBook> bookDAO;
    @Autowired
    private ISysLogService logService;

    public String addBook(Book book) {
        TBook tBook = new TBook();
        BeanUtils.copyProperties(book, tBook);

        tBook.setBookId(UUID.randomUUID().toString());
        tBook.setBookPhoto("app/images/effectivejava.jpg");
        tBook.setCreateTime(new Timestamp(System.currentTimeMillis()));
        tBook.setLend(0);

        TBook bookFromDb =  bookDAO.get("from TBook t where replace(t.bookName, ' ', '')=?0", new String[]{tBook.getBookName().trim()});
        if(bookFromDb != null) {
            return "error";
        }

        System.out.println("Book's id is " + tBook.getBookId());
        bookDAO.save(tBook);
        logService.saveSysLog(tBook, ISysLogService.CREATE);

        return "success";
    }

    public String deleteBook(String bookId) {
        return "success";
    }
}
