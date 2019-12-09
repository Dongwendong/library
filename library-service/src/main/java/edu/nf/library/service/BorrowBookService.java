package edu.nf.library.service;

import com.github.pagehelper.PageInfo;
import edu.nf.library.entity.BorrowBook;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author dwd
 * @date 2019/12/3
 */
public interface BorrowBookService {
    PageInfo<BorrowBook>borrowBook(Integer pageNum, Integer pageSize);
    BorrowBook returnBook(Integer userId,Integer BookId);
    void updataBorrowBook(Integer userId ,Integer bookowId,Integer borrowId ,Integer operator);
    PageInfo<BorrowBook>borrowBook1(Integer pageNum,  Integer pageSize, String phone, Integer bookId);
    BorrowBook getBorrowBookIdMessage(Integer userId);
    PageInfo<BorrowBook>listStatic(Integer pageNum,  Integer pageSize, Integer bookStatic, Date bookData, String bookType);

}