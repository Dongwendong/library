package edu.nf.library.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.library.dao.BookTypeDao;
import edu.nf.library.entity.BookType;
import edu.nf.library.service.BookTypeService;
import edu.nf.library.service.exception.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dwd
 * @date 2019/11/22
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    BookTypeDao dao;

    @Override
    public void addBookType(BookType bookType) {
        try {
            dao.addBookType(bookType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据库异常！添加失败");
        }
    }

    @Override
    public List<BookType> listBookType(String num) {
        try {
            List<BookType> list = dao.listBookType(num);
            return list;
        } catch (Exception e) {
            throw new DataBaseException("数据库异常，查询失败");
        }
    }
}