package edu.nf.library.controller.vo;

/**
 * @author dwd
 * @date 2019/11/21
 */
public class ResponseVO<T> {
    private Object message;
    private Integer code;
    private T data;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}