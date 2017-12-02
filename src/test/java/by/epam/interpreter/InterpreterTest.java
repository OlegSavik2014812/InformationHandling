package by.epam.interpreter;

import by.epam.conversion.ExpressionConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InterpreterTest {
    private final static String VALID_EXPRESSION = "1+2+3*1*2*3";
    private final static String INVALID_EXPRESSION = "1+2+asdf3*+1*2*3";
    private String validPostfix;
    private String invalidPostfix;

    @BeforeMethod
    public void setUp() throws Exception {
        validPostfix = ExpressionConverter.convertToPostfix(VALID_EXPRESSION);
        invalidPostfix = ExpressionConverter.convertToPostfix(INVALID_EXPRESSION);
    }

    @Test
    public void shouldCalculateTest() throws Exception {
        Interpreter interpreter = new Interpreter();
        String result = String.format("%.2f", interpreter.calculate(validPostfix).doubleValue());
        Assert.assertEquals(result, "21,00");
    }

    @Test
    public void shouldNotCalculateTest() throws Exception {
        Interpreter interpreter = new Interpreter();
        String result = String.format("%.2f", interpreter.calculate(invalidPostfix).doubleValue());
        Assert.assertNotEquals(result, "21,00");
    }
}