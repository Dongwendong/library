package edu.nf.library.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.library.dao.BookMessageDao;
import edu.nf.library.entity.BookMessage;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.BookMessageService;
import edu.nf.library.service.exception.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dwd
 * @date 2019/11/25
 */
@Service("bookMessageService")
public class BookMessageServiceImpl implements BookMessageService {
    @Autowired
    BookMessageDao dao;

    @Override
    public void addBookMessage(BookMessage message) {
        try {

            dao.addBookMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据库异常！添加失败");
        }

    }

    @Override
    public PageInfo<BookMessage> listBook(Integer pageNum, Integer pageSize) {
        try {
            List<BookMessage> bookMessageList = dao.listBook(pageNum, pageSize);
            PageInfo<BookMessage> pageInfo = new PageInfo<>(bookMessageList);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据库异常！查询失败");
        }
    }

    @Override
    public BookMessage getIdMessage(Integer id) {
        try {
            return dao.getIdMessage(id);
        } catch (Exception e) {
            throw new DataBaseException("数据库异常！查询失败");
        }
    }

    @Override
    public void updateBook(BookMessage message) {
        try {
            dao.updateBook(message);
        } catch (Exception e) {
            throw new DataBaseException("数据库异常！操作失败");
        }
    }

    @Override
    public PageInfo<BookMessage> detail(Integer pageNum, Integer pageSize, BookMessage message) {
        List<BookMessage>messages=dao.detail(pageNum, pageSize, message);
        if (messages.size()>0){
            PageInfo<BookMessage>pageInfo=new PageInfo<>(messages);
            return  pageInfo;
        }
        throw new DataBaseException("没有找该书籍信息，请重新输入");
    }
}