package by.epam.service;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAction implements InfoHandlingAction {
    protected List<TextComponent> getAllSentences(TextComponent textComponent) throws InfoHandlingException {
        List<TextComponent> sentences = new ArrayList<>();
        for (TextComponent paragraph : textComponent.getList()) {
            sentences.addAll(paragraph.getList());
        }
        return sentences;
    }
}
