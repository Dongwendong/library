package edu.nf.library.service;

import edu.nf.library.entity.BookType;

import java.util.List;

/**
 * @author dwd
 * @date 2019/11/22
 */
public interface BookTypeService {
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
}