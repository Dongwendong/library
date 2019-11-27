package edu.nf.library.service.exception;

/**
 * @author dwd
 * @date 2019/11/22
 */
public class BookTypeException extends RuntimeException {
    public BookTypeException(String message) {
        super(message);
    }

    public BookTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookTypeException(Throwable cause) {
        super(cause);
    }
}