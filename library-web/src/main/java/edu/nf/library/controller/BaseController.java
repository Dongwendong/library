package edu.nf.library.controller;

import edu.nf.library.controller.vo.ResponseVO;
import org.springframework.http.HttpStatus;

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