package pl.manciak.thymeleaf.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

///////////////////////////TODO

@ResponseStatus(BAD_REQUEST)
public class InvalidDataFormatException extends RuntimeException{

        public InvalidDataFormatException(String msg) {
            super(msg);
        }

}
