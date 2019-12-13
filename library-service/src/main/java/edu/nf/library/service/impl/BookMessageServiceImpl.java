package edu.nf.library.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.library.dao.BookMessageDao;
import edu.nf.library.entity.BookMessage;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.BookMessageService;
import edu.nf.library.service.exception.DataBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger= LoggerFactory.getLogger(BookMessageServiceImpl.class);
    @Override
    public void addBookMessage(BookMessage message) {
        try {

            dao.addBookMessage(message);
            logger.info(message.getBookName()+"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(message.getBookName()+"添加失败");
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
            logger.info("分页查询失败");
            throw new DataBaseException("数据库异常！查询失败");
        }
    }

    @Override
    public BookMessage getIdMessage(Integer id) {
        try {
            BookMessage bookMessage= dao.getIdMessage(id);
            logger.info(bookMessage.getBookName()+"查询成功");
            return bookMessage;

        } catch (Exception e) {
            logger.info(id+"查询失败");
            throw new DataBaseException("数据库异常！查询失败");

        }
    }

    @Override
    public void updateBook(BookMessage message) {
        try {
            dao.updateBook(message);
            logger.info(message.getBookName()+"修改成功");
        } catch (Exception e) {
            logger.info(message.getBookName()+"修改失败");
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