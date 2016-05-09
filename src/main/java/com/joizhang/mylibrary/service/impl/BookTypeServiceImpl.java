package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.TBook;
import com.joizhang.mylibrary.model.po.TBooktype;
import com.joizhang.mylibrary.model.vo.BookType;
import com.joizhang.mylibrary.service.IBookTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/5/9.
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements IBookTypeService {

    @Autowired
    private IBaseDao<TBooktype> tBookTypeIBaseDao;

    public List<BookType> getAllBookTypes() {

        return changeModel(tBookTypeIBaseDao.find("from TBooktype"));
    }

    public BookType getBookType(String bookType) {
        List<TBooktype> tBooktypes = tBookTypeIBaseDao.find("from TBooktype where bookType=?0", new Object[]{bookType});
        BookType bookTypeEntity = new BookType();
        if (tBooktypes.size() >0) {
            BeanUtils.copyProperties(tBooktypes.get(0), bookTypeEntity);
        }
        return bookTypeEntity;
    }

    public void saveBookType(TBooktype tBookType) {
        tBookType.setBookTypeId(UUID.randomUUID().toString());
        tBookTypeIBaseDao.save(tBookType);
    }

    private List<BookType> changeModel(List<TBooktype> tBooktypes) {
        List<BookType> bookTypes = new ArrayList<BookType>();
        if (tBooktypes != null && tBooktypes.size() > 0) {
            for (TBooktype tBooktype : tBooktypes) {
                BookType bookType = new BookType();
                BeanUtils.copyProperties(tBooktype, bookType);

                bookTypes.add(bookType);
            }
        }
        return bookTypes;
    }
}
