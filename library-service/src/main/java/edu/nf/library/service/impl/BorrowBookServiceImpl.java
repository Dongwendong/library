package edu.nf.library.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.library.dao.BookMessageDao;
import edu.nf.library.dao.BorrowBookDao;
import edu.nf.library.entity.BorrowBook;
import edu.nf.library.service.BorrowBookService;
import edu.nf.library.service.exception.DataBaseException;
import edu.nf.library.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author dwd
 * @date 2019/12/3
 */
@Service("borrowBookService")
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    private BorrowBookDao dao;
    @Autowired
    private BookMessageDao dao1;
    private final static Logger logger= LoggerFactory.getLogger(BookTypeServiceImpl.class);

    @Override
    public PageInfo<BorrowBook> borrowBook(Integer pageNum, Integer pageSize) {
        try {
            List<BorrowBook> bookList = dao.borrowBook(pageNum, pageSize);
            PageInfo<BorrowBook> pageInfo = new PageInfo<>(bookList);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据异常，查询失败");
        }

    }

    @Override
    public BorrowBook returnBook(Integer userId, Integer BookId) {
        BorrowBook borrowBook = dao.returnBook(userId, BookId);
        if (borrowBook != null) {
            return borrowBook;
        }
        throw new DataBaseException("没有查询到给书籍，请查证后在输入！");
    }

    @Override
    public void updataBorrowBook(Integer userId, Integer bookowId, Integer borrowId, Integer operator) {
        try {
            dao.updataBorrowBook(userId, bookowId, borrowId, operator, DateUtil.getData());
            dao1.updateBookNum(bookowId);
            logger.info("用户编号为："+userId+"归还书籍:"+bookowId+"系统操作者是"+operator);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("用户编号为"+userId+"还书失败");
            throw new DataBaseException("数据异常，还书失败。");
        }
    }

    @Override
    public PageInfo<BorrowBook> borrowBook1(Integer pageNum, Integer pageSize, String phone, Integer bookId) {
        List<BorrowBook> bookList = dao.borrowBook1(pageNum, pageSize, phone, bookId);
            if (bookList.size()>0){
                PageInfo<BorrowBook> pageInfo=new PageInfo<>(bookList);
                return pageInfo;
            }
        throw new DataBaseException("没有查询借书信息,请确认输入的信息正确");
    }

    @Override
    public BorrowBook getBorrowBookIdMessage(Integer userId) {
        try {
            return dao.getBorrowBookIdMessage(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("数据库异常，查询失败");
        }
    }

    @Override
    public PageInfo<BorrowBook> listStatic(Integer pageNum, Integer pageSize, Integer bookStatic, Date bookData, String bookType) {
           List<BorrowBook>list= dao.listStatic(pageNum, pageSize, bookStatic, bookData, bookType);
           if (list.size()>0){
               PageInfo<BorrowBook>pageInfo=new PageInfo<>(list);
               return pageInfo;
           }
           throw new DataBaseException("没有找到书籍信息，");

    }
}