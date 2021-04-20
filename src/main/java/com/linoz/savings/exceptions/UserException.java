package com.linoz.savings.exceptions;

import javax.ws.rs.ext.Provider;

/**
 * Created by linoz on 4/16/21
 */
@Provider
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
