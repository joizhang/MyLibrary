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

    /**
     * 获得图书列表
     * @param pager
     * */
    public Pager<Book> getBookList(Pager<Book> pager, String search);

    /**
     * 删除图书
     * @param bookId 图书的id
     * */
    public void deleteBook(String bookId);

    /**
     * 更新书籍的封面路径
     * @param photoFolder 存放图书图片的路径
     * @param uploadFileFileName 图片名称
     * */
    public void updatePhotoPath(String photoFolder, String uploadFileFileName);
}
