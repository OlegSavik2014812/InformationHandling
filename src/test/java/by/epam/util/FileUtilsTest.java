package by.epam.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUtilsTest {
    private final static String PATH_OF_INPUTFILE = "inputdata/text_handling.txt";

    @Test
    public void testOpenFile() throws Exception {
        Assert.assertTrue(FileUtils.openFile(PATH_OF_INPUTFILE).exists());
    }
}