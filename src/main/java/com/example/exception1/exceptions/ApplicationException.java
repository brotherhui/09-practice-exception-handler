package com.example.exception1.exceptions;

import com.example.exception1.ErrorCode;

/**

 *
 * Created on 07.02.17.
 */
public interface ApplicationException {

    default String getStringErrorCode() {
        return this.getErrorCode().getMessageCode();
    }

    ErrorCode getErrorCode();

    default Object[] getArgs() {
        return new Object[0];
    }
}
