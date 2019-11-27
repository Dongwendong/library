package edu.nf.library.service.exception;

/**
 * @author dwd
 * @date 2019/11/22
 */
public class DataBaseException extends RuntimeException{
    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }
}