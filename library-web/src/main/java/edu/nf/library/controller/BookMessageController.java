package edu.nf.library.controller;

import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.entity.BookMessage;
import edu.nf.library.service.BookMessageService;
import edu.nf.library.service.exception.DataBaseException;
import edu.nf.library.util.FilesUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/addBook")
    public ResponseVO addBook(MultipartFile file, BookMessage message, HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        String path = "E:" + File.separator + "JavaFile" + File.separator + "library" + File.separator + "library-web" + File.separator + "web" + File.separator + "static"+File.separator+"imges";
        fileName = FilesUploadUtil.newFileName(fileName);
        File uploadFile = FilesUploadUtil.createUploadFile(path, fileName);
        try {
            file.transferTo(uploadFile);
            message.setBookImg(fileName);
            service.addBookMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataBaseException("图片上传失败！");
        }
        return success(message.getBookName() + "添加成功");
    }
}