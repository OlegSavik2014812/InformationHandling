package by.epam.parsing;

import by.epam.inforeader.TextReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ComponentParserTest {
    private final static String PATH_OF_INPUTFILE = "inputdata/text_handling.txt";
    private final static String SENTENCE_REGEX = "[^.]*[^.]*\\.";

    @Test
    public void shouldParseTest() throws Exception {
        List<String> list = ComponentParser.parse(TextReader.readText(PATH_OF_INPUTFILE), SENTENCE_REGEX);
        Assert.assertEquals(list.isEmpty(), false);
    }
}