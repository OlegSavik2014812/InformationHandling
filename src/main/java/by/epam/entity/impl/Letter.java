package by.epam.entity.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Letter implements TextComponent {
    private final static Logger LOGGER = LogManager.getLogger();
    private String letter;

    public Letter(String letter) {
        this.letter = letter;
    }

    @Override
    public void addTextComponent(TextComponent textComponent) throws InfoHandlingException {
        LOGGER.error("unacceptable method" + this);
        throw new InfoHandlingException();
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) throws InfoHandlingException {
        LOGGER.error("unacceptable method" + this);
        throw new InfoHandlingException();
    }

    @Override
    public void clear() throws InfoHandlingException {
        LOGGER.error("unacceptable method" + this);
        throw new InfoHandlingException();
    }

    @Override
    public List<TextComponent> getList() throws InfoHandlingException {
        LOGGER.error("unacceptable method" + this);
        throw new InfoHandlingException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter1 = (Letter) o;
        return letter != null ? letter.equals(letter1.letter) : letter1.letter == null;
    }

    @Override
    public int hashCode() {
        return letter != null ? letter.hashCode() : 0;
    }

    @Override
    public String toString() {
        return letter + "";
    }
}



