package com.example.exception1.exceptions;

import com.example.exception1.ErrorCode;

/**
 *
 * Created on 18.02.17.
 */
public class PollException extends RuntimeException implements ApplicationException {
    private final ErrorCode code;

    public PollException(ErrorCode code) {
        this.code = code;
    }

    @Override
    public ErrorCode getErrorCode() {
        return code;
    }
}
