package by.epam.handling.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;
import by.epam.inforeader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParagraphHandlerTest {
    private final static String PATH_OF_INPUTFILE = "inputdata/text_handling.txt";
    private String line;

    @BeforeMethod
    public void setUp() throws Exception {
        line = TextReader.readText(PATH_OF_INPUTFILE);
    }

    @Test
    public void shouldTestParagraphHandle() throws InfoHandlingException {
        ParagraphHandler paragraphHandler = new ParagraphHandler();
        TextComponent textComponent = paragraphHandler.handle(line);
        Assert.assertTrue(textComponent.getClass().getSimpleName().equals("Paragraph"));
    }

    @Test
    public void shouldNotTestParagraphHandle() throws InfoHandlingException {
        ParagraphHandler paragraphHandler = new ParagraphHandler();
        TextComponent textComponent = paragraphHandler.handle(line);
        Assert.assertFalse(textComponent.getClass().getSimpleName().equals("Text"));
    }

}