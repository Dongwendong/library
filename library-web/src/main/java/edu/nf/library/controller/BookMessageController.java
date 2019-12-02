package edu.nf.library.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.entity.BookMessage;
import edu.nf.library.service.BookMessageService;
import edu.nf.library.service.exception.DataBaseException;
import edu.nf.library.util.FilesUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author dwd
 * @date 2019/11/25
 */
@RestController
public class BookMessageController extends BaseController {
    @Autowired
    private BookMessageService service;

    @InitBinder
    public void convertDate(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @PostMapping("/listBook")
    public ResponseVO<PageInfo<BookMessage>> listBook(Integer pageNum, Integer pageSize) {
        return success(service.listBook(pageNum, pageSize));
    }

    private Integer bookId;

    @PostMapping("/bookId")
    public ResponseVO getId(Integer id) {
        bookId = id;
        return success("ok");
    }

    @GetMapping("/idBookMessage")
    public ResponseVO idMessage() {
        BookMessage message = service.getIdMessage(bookId);
        return success(service.getIdMessage(bookId));
    }

    @PostMapping("/updateBook")
    public ResponseVO updateBook(BookMessage message) {
        System.out.println(message.getSuitable());
        service.updateBook(message);
        return success("修改成功");
    }

    @PostMapping("/updateBook1")
    public ResponseVO updateBook(MultipartFile file, BookMessage message) {
        System.out.println(message.getSuitable());
        String path = "E:" + File.separator + "JavaFile" + File.separator + "library" + File.separator + "library-web" + File.separator + "web" + File.separator + "static" + File.separator + "imges";
        String imgName = fileUpload(file, path);
        message.setBookImg(imgName);
        service.updateBook(message);
        return success("修改成功");
    }

    @PostMapping("/addBook")
    public ResponseVO addBook(MultipartFile file, BookMessage message, HttpServletRequest request) {
        String path = "E:" + File.separator + "JavaFile" + File.separator + "library" + File.separator + "library-web" + File.separator + "web" + File.separator + "static" + File.separator + "imges";
        String imgName = fileUpload(file, path);
        message.setBookImg(imgName);
        service.addBookMessage(message);
        return success(message.getBookName() + "添加成功");
    }
    @RequestMapping("/bookImg")
    public ResponseVO test1(MultipartFile file,HttpServletRequest request){
        return success(test(file,request)) ;
    }
}