package by.epam.service;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;

public interface InfoHandlingAction<T> {
    T realize(TextComponent textComponent) throws InfoHandlingException;
}
