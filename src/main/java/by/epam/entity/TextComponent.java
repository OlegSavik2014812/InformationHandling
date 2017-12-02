package by.epam.entity;

import by.epam.exception.InfoHandlingException;

import java.util.List;

public interface TextComponent {
    void addTextComponent(TextComponent textComponent) throws InfoHandlingException;

    void removeTextComponent(TextComponent textComponent) throws InfoHandlingException;

    void clear() throws InfoHandlingException;
    List<TextComponent> getList() throws InfoHandlingException;
}
