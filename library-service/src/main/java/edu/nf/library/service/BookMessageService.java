package edu.nf.library.service;

import com.github.pagehelper.PageInfo;
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

    /***
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BookMessage> listBook(Integer pageNum,Integer pageSize);
    BookMessage getIdMessage(Integer id);
    void updateBook(BookMessage message);
}