package edu.nf.library.dao;

import edu.nf.library.entity.BorrowBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author dwd
 * @date 2019/12/3
 */
@Repository("borrowBookDao")
public interface BorrowBookDao {

    List<BorrowBook>borrowBook(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    BorrowBook returnBook(Integer userId,Integer BookId);
    void updataBorrowBook(Integer userId , Integer bookowId, Integer borrowId , Integer operator, Date data);
    List<BorrowBook>borrowBook1(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String phone,Integer bookId);
    BorrowBook getBorrowBookIdMessage(Integer userId);
    List<BorrowBook>listStatic(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,Integer bookStatic,Date bookData,String bookType);

}