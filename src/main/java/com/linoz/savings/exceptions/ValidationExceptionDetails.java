package com.linoz.savings.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Created by linoz on 4/26/21
 */
@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldsMessage;
}
