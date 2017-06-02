package io.egen.prashanth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ppeddabbu on 5/30/2017.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadrequestException extends RuntimeException{

    public BadrequestException(String message){
        super(message);
    }

    public BadrequestException(String message, Throwable cause){
        super(message,cause);
    }

}

