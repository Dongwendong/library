package edu.nf.library.dao;

import edu.nf.library.entity.BookMessage;
import org.springframework.stereotype.Repository;

/**
 * @author dwd
 * @date 2019/11/24
 */
@Repository("bookMessageDao")
public interface BookMessageDao {
    /***
     * 添加图书信息
     * @param message
     */
    void addBookMessage(BookMessage message);
}