package com.example.jobapp.exceptions;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {

    public BusinessLogicException() {
        super();
    }

    public BusinessLogicException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(Throwable cause) {
        super(cause);
    }
}
