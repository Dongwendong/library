package edu.nf.library.controller;

import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.entity.BookType;
import edu.nf.library.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dwd
 * @date 2019/11/22
 */
@RestController
public class BookTypeController extends BaseController {
    @Autowired
    BookTypeService service;
    @PostMapping("/listBookType")
    public ResponseVO listBookType(String num) {
        System.out.println(num);
        return success(service.listBookType(num));
    }
    @PostMapping("/addBookType")
    public ResponseVO addBookType(BookType bookType){
        service.addBookType(bookType);
        return success("图书类型添加成功");
    }

}