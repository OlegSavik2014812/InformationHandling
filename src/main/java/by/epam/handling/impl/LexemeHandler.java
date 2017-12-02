package by.epam.handling.impl;

import by.epam.entity.TextComponent;
import by.epam.entity.impl.Letter;
import by.epam.entity.impl.Lexeme;
import by.epam.entity.impl.Symbol;
import by.epam.exception.InfoHandlingException;
import by.epam.handling.ComponentHandler;

public class LexemeHandler implements ComponentHandler {
    private final static String LETTER_REGEX = "([A-Za-z]+)";
    private TextComponent textComponent;

    public LexemeHandler() {
        textComponent = new Lexeme();
    }

    @Override
    public TextComponent handle(String lexeme) throws InfoHandlingException {
        for (int i = 0; i < lexeme.length(); i++) {
            String lexemeChar = String.valueOf(lexeme.charAt(i));
            if (lexemeChar.matches(LETTER_REGEX)) {
                textComponent.addTextComponent(new Letter(lexemeChar));
            } else {
                textComponent.addTextComponent(new Symbol(lexemeChar));
            }
        }
        return textComponent;
    }
}
