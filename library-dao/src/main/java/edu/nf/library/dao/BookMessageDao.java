package edu.nf.library.dao;

import edu.nf.library.entity.BookMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /***
     * 查询所有图书
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<BookMessage>listBook(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    /***
     * id查询图书
     * @param id
     * @return
     */
    BookMessage getIdMessage(Integer id);

    /***
     * 修改图书信息
     * @param message
     */
    void updateBook(BookMessage message);
    List<BookMessage> detail(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,BookMessage message);
    void updateBookNum(Integer bookId);
}