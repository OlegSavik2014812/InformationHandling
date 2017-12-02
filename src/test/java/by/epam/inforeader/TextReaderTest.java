package by.epam.inforeader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TextReaderTest {
    private final static String PATH_OF_INPUTFILE = "inputdata/text_handling.txt";

    @Test
    public void testReadText() throws Exception {
        String line = TextReader.readText(PATH_OF_INPUTFILE);
        Assert.assertEquals(line.isEmpty(), false);
    }
}