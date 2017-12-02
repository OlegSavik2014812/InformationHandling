package by.epam.handling.impl;

import by.epam.entity.TextComponent;
import by.epam.entity.impl.Text;
import by.epam.exception.InfoHandlingException;
import by.epam.handling.ComponentHandler;
import by.epam.parsing.ParagraphParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TextHandler implements ComponentHandler {
    private final static String PARAGRAPH_REGEX = "\t";
    private final static Logger LOGGER = LogManager.getLogger();
    private TextComponent textComponent;

    public TextHandler() {
        textComponent = new Text();
    }

    @Override
    public TextComponent handle(String line) throws InfoHandlingException {
        List<String> paragraphs = ParagraphParser.parse(line, PARAGRAPH_REGEX);
        try {
            for (String paragraph : paragraphs) {
                textComponent.addTextComponent(new ParagraphHandler().handle(paragraph));
            }
        } catch (InfoHandlingException e) {
            LOGGER.error(e);
            throw new InfoHandlingException("cant build");
        }
        LOGGER.info("\n" + textComponent);
        return textComponent;
    }
}
