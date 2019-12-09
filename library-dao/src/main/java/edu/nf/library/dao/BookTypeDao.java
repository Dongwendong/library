package edu.nf.library.dao;

import edu.nf.library.entity.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dwd
 * @date 2019/11/22
 */
@Repository("bookTypeDao")
public interface BookTypeDao {
    /***
     * 添加图书类型
     * @param bookType
     */
    void addBookType(BookType bookType);

    /***
     * 查询类型；
     * @return
     */
    List<BookType> listBookType(String num);
    List<BookType>list();
}