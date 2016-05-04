package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.SysLog;
import com.joizhang.mylibrary.model.po.TBook;
import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.model.vo.Pager;
import com.joizhang.mylibrary.service.IBookService;
import com.joizhang.mylibrary.service.ISysLogService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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

    public boolean addBook(Book book) {
        TBook tBook = new TBook();
        BeanUtils.copyProperties(book, tBook);

        tBook.setBookId(UUID.randomUUID().toString());
        tBook.setBookPhoto("app/images/effectivejava.jpg");
        tBook.setCreateTime(new Timestamp(System.currentTimeMillis()));
        tBook.setLend(0);

        TBook bookFromDb = bookDAO.get("from TBook t where replace(t.bookName, ' ', '')=?0 or t.bookNumber=?1", new String[]{tBook.getBookName().trim(), tBook.getBookNumber()});
        if (bookFromDb != null) {
            return false;
        }

        //System.out.println("Book's id is " + tBook.getBookId());
        bookDAO.save(tBook);
        logService.saveSysLog(tBook, ISysLogService.CREATE);

        return true;
    }

    public Pager<Book> getBookList(Pager<Book> pager, String search) {
        System.out.println(ReflectionToStringBuilder.toString(pager));

        Pager<Book> returnPager = new Pager<Book>();
        //算出总数据条数
        returnPager.setTotalRecord(bookDAO.count("select count(bookId) from TBook"));
        //算出总页数
        returnPager.setTotalPage(bookDAO.countPage("select count(bookId) from TBook", pager.getPageSize()));

        StringBuffer sbf = new StringBuffer();
        sbf.append("from TBook t");
        //获得记录集
        if (search != null && !search.equals("")) {
            sbf.append(" where t.bookName like ?0");
            returnPager.setDataList(changeModel(bookDAO.find(sbf.toString(), new Object[]{search}, pager.getCurrentPage(), pager.getPageSize())));
        } else {
            returnPager.setDataList(changeModel(bookDAO.find(sbf.toString(), new Object[]{}, pager.getCurrentPage(), pager.getPageSize())));
        }

        //当前页
        returnPager.setCurrentPage(pager.getCurrentPage());
        //每页记录数
        returnPager.setPageSize(pager.getPageSize());

        return returnPager;
    }

    private List<Book> changeModel(List<TBook> tBooks) {		//将RmsUser转换为User
        List<Book> books = new ArrayList<Book>();
        if (tBooks != null && tBooks.size() > 0) {
            for (TBook tBook : tBooks) {
                Book book = new Book();
                BeanUtils.copyProperties(tBook, book);

                books.add(book);
            }
        }
        return books;
    }

    public void deleteBook(String bookId) {
        //System.out.println(ReflectionToStringBuilder.toString(bookDAO.get(TBook.class, bookId)));
        bookDAO.delete(bookDAO.get(TBook.class, bookId));
    }

    public void updatePhotoPath(String photoFolder, String uploadFileFileName) {
        String filePrefix = uploadFileFileName.substring(0, uploadFileFileName.lastIndexOf("."));
        List<TBook> tBooks = new ArrayList<TBook>();
        TBook tBook = new TBook();
        try {
            tBooks = bookDAO.find("from TBook t where bookNumber like ?0", new String[] {'%'+filePrefix+'%'});
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tBooks.size() > 0) {
            tBook = (TBook) tBooks.get(0);
            tBook.setBookPhoto(photoFolder + uploadFileFileName);
        }
        bookDAO.update(tBook);
    }
}
