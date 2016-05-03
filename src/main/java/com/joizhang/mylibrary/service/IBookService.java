package com.joizhang.mylibrary.service;

import com.joizhang.mylibrary.model.vo.Book;
import com.joizhang.mylibrary.model.vo.Pager;

/**
 * Created by Administrator on 2016/4/22.
 */
public interface IBookService {

    /**
     * 添加图书
     * @param book 图书信息
     * */
    public boolean addBook(Book book);

    public Pager<Book> getBookList(Pager<Book> pager, String search);

    public void deleteBook(String bookId);
}
