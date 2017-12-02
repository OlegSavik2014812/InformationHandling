package by.epam.service.sorter;

import by.epam.entity.TextComponent;
import by.epam.handling.impl.TextHandler;
import by.epam.inforeader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SentenceSorterTest {
    private final static String PATH_OF_INPUTFILE = "inputdata/text_handling.txt";
    private TextComponent textComponent;

    @BeforeMethod
    public void setUp() throws Exception {
        TextHandler textHandler = new TextHandler();
        textComponent = textHandler.handle(TextReader.readText(PATH_OF_INPUTFILE));
    }

    @Test
    public void testRealize() throws Exception {
        SentenceSorter sentenceSorter = new SentenceSorter();
        List<TextComponent> list = sentenceSorter.realize(textComponent);
        Assert.assertNotSame(textComponent, list);
    }
}