package pl.manciak.thymeleaf.validate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CorrectNumericValuesTests {


    @Parameterized.Parameters
    public static Object[] testData(){
        return new Object[]{"0",
                "22",
                "213524",
                "111,22",
                "111.22"
        };
    }

    @Parameterized.Parameter(value = 0)
    public String testedValue;

    @Test()
    public void checkIfNumericCorrectTest() {
        Assert.assertTrue(CheckEnteredValue.checkIfNumeric(testedValue));
    }

}
