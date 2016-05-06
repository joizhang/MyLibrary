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
    boolean addBook(Book book);

    /**
     * 获得图书列表
     * @param pager 分页新息
     * @param search 查询条件
     * */
    Pager<Book> getBookList(Pager<Book> pager, String search);

    /**
     * 删除图书
     * @param bookId 图书的id
     * */
    void deleteBook(String bookId);

    /**
     * 更新书籍的封面路径
     * @param photoFolder 存放图书图片的路径
     * @param uploadFileFileName 图片名称
     * */
    void updatePhotoPath(String photoFolder, String uploadFileFileName);

    /**
     * 借出书籍
     * @param lendBookName 书籍名称
     * @param lendBookNumber 图书编号
     * @param lendBookBorrower 借阅者
     * @param lend 借阅转态
     * */
    String updateBookLend(String lendBookName, String lendBookNumber, String lendBookBorrower, int lend);

    /**
     * 检查借阅信息是否合格
     * @param lendBookName 书籍名称
     * @param lendBookNumber 图书编号
     * @param lendBookBorrower 借阅者
     * */
    String checkLendInfo(String lendBookName, String lendBookNumber, String lendBookBorrower);

    /**
     * 还书
     * @param returnBookName 书籍名称
     * @param returnBookNumber 图书编号
     * @param lend 借阅转态
     * */
    void updateBookReturn(String returnBookName, String returnBookNumber, int lend);
}
