
package com.example.demo.utils.exception;

/**
 * 自定义异常
 */
public class MyDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MyDeniedException() {
    }

    public MyDeniedException(String message) {
        super(message);
    }

    public MyDeniedException(Throwable cause) {
        super(cause);
    }

    public MyDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
