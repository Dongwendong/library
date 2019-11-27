package edu.nf.library.service.exception;

/**
 * @author dwd
 * @date 2019/11/21
 */
public class StaffMessageException extends RuntimeException {
    public StaffMessageException(String message) {
        super(message);
    }

    public StaffMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaffMessageException(Throwable cause) {
        super(cause);
    }
}