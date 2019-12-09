package edu.nf.library.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.StaffMessageService;
import edu.nf.library.service.exception.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @author dwd
 * @date 2019/11/21
 */
@RestController
public class StaffMessageController extends BaseController {
    @Autowired
    private StaffMessageService service;

    @PostMapping("/allStaff")
    public ResponseVO<PageInfo<StaffMessage>> listStaffMessage(Integer pageNum, Integer pageSize) {
        return success(service.listStaff(pageNum, pageSize));
    }

    @RequestMapping("/updateStaff1")
    public ResponseVO updateStaff1(StaffMessage message) {
        service.updataStaff(message);
        return success(message.getStaffName() + "修改成功");
    }

    @RequestMapping("/updateStaff")
    public ResponseVO updateStaff(MultipartFile file, StaffMessage message) {
        String fileName = file.getOriginalFilename();
        if (!fileName.equals("default.jpg")) {
            String path = "E:" + File.separator + "JavaFile" + File.separator +
                    "library" + File.separator + "library-web" + File.separator + "web" + File.separator +
                    "static" + File.separator + "imges";
            fileUpload(file, path);
        }
        message.setStaffImg(fileName);
        service.updataStaff(message);
        return success(message.getStaffName() + "修改成功");
    }

    @InitBinder
    public void convertDate(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @RequestMapping("/addStaff")
    public ResponseVO addStaff(MultipartFile file, @Valid StaffMessage message) {
        String fileName = file.getOriginalFilename();
        if (!fileName.equals("default.jpg")) {
            String path = "E:" + File.separator + "JavaFile" + File.separator +
                    "library" + File.separator + "library-web" + File.separator + "web" + File.separator +
                    "static" + File.separator + "imges";
            fileUpload(file, path);
        }
        message.setStaffImg(fileName);
        service.addStaff(message);
        return success(message.getStaffName() + "添加成功");
    }

    @GetMapping("/getId")
    public ResponseVO getId(Integer id) {
        return success(service.getId(id));
    }

    Integer sid = 0;

    @PostMapping("/id")
    public ResponseVO id(Integer id) {
        sid = id;
        return success("staffIdMessage.html");
    }

    @GetMapping("/getIdMessage")
    public ResponseVO getIdMessage() {
        StaffMessage message = service.getId(sid);
        return success(message);
    }

    @RequestMapping("/test")
    public ResponseVO test1(MultipartFile file, HttpServletRequest request) {
        return success(test(file, request));
    }
    @GetMapping("/staffMessage.do")
    public ResponseVO staffMessage(HttpSession session) {
        StaffMessage message = (StaffMessage) session.getAttribute("staffMessage");
        if(message!=null){
            return success(message);
        }
       throw new DataBaseException("没有找到信息");
    }
}