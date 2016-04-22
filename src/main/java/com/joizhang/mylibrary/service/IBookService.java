package com.joizhang.mylibrary.service;

import com.joizhang.mylibrary.model.vo.Book;

/**
 * Created by Administrator on 2016/4/22.
 */
public interface IBookService {
    public String addBook(Book book);

    public String deleteBook(String bookId);
}
