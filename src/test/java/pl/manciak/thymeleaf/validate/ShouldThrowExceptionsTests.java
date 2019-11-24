package pl.manciak.thymeleaf.validate;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import pl.manciak.thymeleaf.exceptions.InvalidDataFormatException;
import pl.manciak.thymeleaf.exceptions.ResourceNotFoundException;


public class ShouldThrowExceptionsTests {

    private CheckEnteredValue checker = new CheckEnteredValue();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test()
    public void shouldThrowResourceNotFoundException_Test() {
        exception.expect(ResourceNotFoundException.class);
        checker.checkIfNull(null);
    }

    @Test()
    public void shouldThrowInvalidDataFormatException_Test() {
        exception.expect(InvalidDataFormatException.class);
        checker.checkIfNumeric("aaa");
    }

}