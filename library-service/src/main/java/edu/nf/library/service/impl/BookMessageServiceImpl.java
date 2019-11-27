package edu.nf.library.service.impl;

import edu.nf.library.dao.BookMessageDao;
import edu.nf.library.entity.BookMessage;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.BookMessageService;
import edu.nf.library.service.exception.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}