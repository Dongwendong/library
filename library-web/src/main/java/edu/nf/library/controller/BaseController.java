package edu.nf.library.controller;

import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.service.exception.DataBaseException;
import edu.nf.library.util.FilesUploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author dwd
 * @date 2019/11/21
 */
public class BaseController {
    protected <T> ResponseVO<T> success(T data) {
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }
    protected String test(MultipartFile file, HttpServletRequest request){
        String uploadPath = request.getServletContext().getRealPath(File.separator + "static"+File.separator+"imges");
        String fileName= fileUpload(file,uploadPath);
        return fileName ;
    }
    protected String fileUpload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        fileName = FilesUploadUtil.newFileName(fileName);
        File uploadFile = FilesUploadUtil.createUploadFile(path, fileName);
        try {
            file.transferTo(uploadFile);
            return fileName;
        } catch (IOException e) {
            throw new DataBaseException("文件上传失败");
        }
    }
    protected ResponseVO success(String message) {
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.OK.value());
        vo.setMessage(message);
        return vo;
    }

    protected ResponseVO fail(Integer code, Object message) {
        ResponseVO vo = new ResponseVO();
        vo.setMessage(message);
        vo.setCode(code);
        return vo;
    }

    protected ResponseVO fail(Integer code) {
        ResponseVO vo = new ResponseVO();
        vo.setCode(code);
        return vo;
    }
}