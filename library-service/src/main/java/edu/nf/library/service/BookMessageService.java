package edu.nf.library.service;

import edu.nf.library.entity.BookMessage;
import edu.nf.library.entity.StaffMessage;

/**
 * @author dwd
 * @date 2019/11/25
 */
public interface BookMessageService {
    /***
     * 添加书籍信息
     * @param message
     */
    void addBookMessage(BookMessage message);

}