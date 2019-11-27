package edu.nf.library.controller.advice;

import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.service.exception.DataBaseException;
import edu.nf.library.service.exception.StaffMessageException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dwd
 * @date 2019/11/21
 */
@RestControllerAdvice("edu.nf.library.controller")
public class StaffMessageAdvice {
@ExceptionHandler(DataBaseException.class)
public ResponseVO dataException(DataBaseException e){
        ResponseVO vo=new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
        }
@ExceptionHandler(BindException.class)
public ResponseVO validException(BindException e){
        ResponseVO vo=new ResponseVO();
        List<String> list = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            list.add(fieldError.getDefaultMessage());
        }
        list.forEach((s) -> System.out.println(s));
        vo.setCode(600);
        vo.setMessage(list);
        return vo;
        }
}