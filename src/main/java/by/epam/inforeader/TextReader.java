package by.epam.inforeader;

import by.epam.exception.InfoHandlingException;
import by.epam.util.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    private final static Logger LOGGER = LogManager.getLogger();

    public static String readText(String pathOfFile) throws InfoHandlingException, IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FileUtils.openFile(pathOfFile)));
            StringBuilder stringBuffer = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            LOGGER.error("cant read file" + e);
            throw new InfoHandlingException(e);
        } finally {
            reader.close();
        }

    }
}
