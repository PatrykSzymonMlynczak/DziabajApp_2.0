package pl.manciak.thymeleaf.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class InvalidDataFormat extends RuntimeException{

        public InvalidDataFormat(String msg) {
            super(msg);
        }

}
