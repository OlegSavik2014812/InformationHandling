package by.epam.entity.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements TextComponent {
    private final static Logger LOGGER = LogManager.getLogger();
    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
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
        Symbol symbol1 = (Symbol) o;
        return symbol != null ? symbol.equals(symbol1.symbol) : symbol1.symbol == null;
    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }

    @Override
    public String toString() {
        return symbol + "";
    }
}