package io.egen.prashanth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ppeddabbu on 5/30/2017.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotfoundException extends RuntimeException{

    public NotfoundException(String message){
        super(message);
    }

    public NotfoundException(String message, Throwable cause){
        super(message,cause);
    }

}

