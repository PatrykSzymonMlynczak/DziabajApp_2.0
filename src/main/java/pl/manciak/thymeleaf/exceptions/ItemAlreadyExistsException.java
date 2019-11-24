package pl.manciak.thymeleaf.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(CONFLICT)
public class ItemAlreadyExistsException extends RuntimeException  {

    public ItemAlreadyExistsException(String msg){super(msg);}
}
