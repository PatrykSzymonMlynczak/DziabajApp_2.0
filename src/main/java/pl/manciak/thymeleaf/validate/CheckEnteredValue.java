package pl.manciak.thymeleaf.validate;

import pl.manciak.thymeleaf.exceptions.InvalidDataFormatException;
import pl.manciak.thymeleaf.exceptions.ResourceNotFoundException;

import java.util.regex.Pattern;
//
// Klasa dla testów jednostkowych

public class CheckEnteredValue {


    public static boolean checkIfNull(String checkedValue){
        if(checkedValue == null){
            throw new ResourceNotFoundException(String.format("Entered Value %d cannot be blank", checkedValue));
        }
        else return true;
    }


    public static boolean checkIfNumeric(String checkedNumber){

        boolean check = Pattern.matches("([0-9\\,\\.])*", checkedNumber);
        if(!check){
            throw new InvalidDataFormatException(String.format("Entered Value must be numeric"));
        }
        else return true;
    }



}
