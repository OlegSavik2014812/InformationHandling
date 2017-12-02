package by.epam.handling.impl;

import by.epam.entity.TextComponent;
import by.epam.entity.impl.Paragraph;
import by.epam.exception.InfoHandlingException;
import by.epam.handling.ComponentHandler;
import by.epam.parsing.ComponentParser;

import java.util.List;

public class ParagraphHandler implements ComponentHandler {
    private final static String SENTENCE_REGEX = "[^.]*[^.]*\\.";
    private TextComponent paragraphComponent;

    public ParagraphHandler() {
        paragraphComponent = new Paragraph();
    }

    @Override
    public TextComponent handle(String paragraph) throws InfoHandlingException {
        List<String> sentences = ComponentParser.parse(paragraph, SENTENCE_REGEX);
        for (String sentence : sentences) {
            paragraphComponent.addTextComponent(new SentenceHandler().handle(sentence));
        }
        return paragraphComponent;
    }
}
