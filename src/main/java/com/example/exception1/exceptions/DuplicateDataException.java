package com.example.exception1.exceptions;

import com.example.exception1.ErrorCode;

/**

 *
 * Created on 07.02.17.
 */
public class DuplicateDataException extends RuntimeException implements ApplicationException{
    private final ErrorCode code;
    private final Object[] args;

    public DuplicateDataException(ErrorCode code, Object[] args) {
        this.code = code;
        this.args = args;
    }

    @Override
    public String getStringErrorCode() {
        return code.getMessageCode();
    }

    @Override
    public ErrorCode getErrorCode() {
        return code;
    }

    @Override
    public Object[] getArgs() {
        return args;
    }

}
