package by.epam.handling.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;
import by.epam.inforeader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LexemeHandlerTest {
    private final static String PATH_OF_INPUTFILE = "inputdata/text_handling.txt";
    private String line;

    @BeforeMethod
    public void setUp() throws Exception {
        line = TextReader.readText(PATH_OF_INPUTFILE);
    }

    @Test
    public void shouldTestLexemeHandle() throws InfoHandlingException {
        LexemeHandler lexemeHandler = new LexemeHandler();
        TextComponent textComponent = lexemeHandler.handle(line);
        Assert.assertTrue(textComponent.getClass().getSimpleName().equals("Lexeme"));
    }

    @Test
    public void shouldNotTestLexemeHandle() throws InfoHandlingException {
        LexemeHandler lexemeHandler = new LexemeHandler();
        TextComponent textComponent = lexemeHandler.handle(line);
        Assert.assertFalse(textComponent.getClass().getSimpleName().equals("Sentence"));
    }
}