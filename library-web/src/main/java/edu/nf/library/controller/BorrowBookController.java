package edu.nf.library.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.entity.BorrowBook;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author dwd
 * @date 2019/12/3
 */
@RestController
public class BorrowBookController extends BaseController {
    @Autowired
    private BorrowBookService service;

    @PostMapping("/listBorrowBook")
    public ResponseVO<PageInfo<BorrowBook>> listBorrowBook(Integer pageNum, Integer pageSize) {
        return success(service.borrowBook(pageNum, pageSize));
    }

    @PostMapping("/returnBook")
    public ResponseVO returnBook(Integer userId, Integer bookId) {
        return success(service.returnBook(userId, bookId));
    }

    @InitBinder
    public void convertDate(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @PostMapping("/updateBorrow")
    public ResponseVO updateBorrow(Integer userId, Integer bookowId, Integer borrowId, HttpSession session) {
        StaffMessage message = (StaffMessage) session.getAttribute("staffMessage");
        service.updataBorrowBook(userId, bookowId, borrowId, message.getStaffId());
        return success("还书成功");
    }

    @PostMapping("/returnBookMessage")
    public ResponseVO<PageInfo<BorrowBook>> returnBookMessage(Integer pageNum, Integer pageSize, String phone, Integer bookId) {
        return success(service.borrowBook1(pageNum, pageSize, phone, bookId));
    }

    @PostMapping("/getBorrowBookIdMessage")
    public ResponseVO getBorrowBookIdMessage(Integer borrowId) {
        return success(service.getBorrowBookIdMessage(borrowId));
    }

    @PostMapping("/getStatic.do")
    public ResponseVO<PageInfo<BorrowBook>> getStatic(Integer pageNum, Integer pageSize, Integer bookStatic, Date bookData, String bookType) {
        return success(service.listStatic(pageNum, pageSize, bookStatic, bookData, bookType));
    }
}