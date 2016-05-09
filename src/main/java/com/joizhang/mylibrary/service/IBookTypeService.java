package com.joizhang.mylibrary.service;

import com.joizhang.mylibrary.model.po.TBooktype;
import com.joizhang.mylibrary.model.vo.BookType;

import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
public interface IBookTypeService {
    /**
     * 获得所有的书籍类型
     * */
    List<BookType> getAllBookTypes();

    /**
     * 根据书籍类型获得书籍类型
     * @param bookType 书籍类型
     * */
    BookType getBookType(String bookType);

    /**
     * 保存书籍类型
     * @param tBookType 书籍类型实体
     * */
    void saveBookType(TBooktype tBookType);
}
