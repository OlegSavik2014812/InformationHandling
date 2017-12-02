package by.epam.conversion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpressionConverterTest {
    private final static String VALID_EXPRESSION = "2+3+4+5*(5*2+3-4*(1/2))";
    private final static String INVALID_EXPRESSION = "2+3+qwerty4+5*(5*2+3-4*(1/2))";

    @Test
    public void shouldConvertToPostfixTest() throws Exception {
        Assert.assertEquals(ExpressionConverter.convertToPostfix(VALID_EXPRESSION), "2 3 + 4 + 5 5 2 * 3 + 4 1 2 / * - * +");
    }
    @Test
    public void shouldNotConvertToPostfixTest() throws Exception {
        Assert.assertNotEquals(ExpressionConverter.convertToPostfix(INVALID_EXPRESSION), "2 3 + 4 + 5 5 2 * 3 + 4 1 2 / * - * +");
    }
}