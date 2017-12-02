package by.epam.entity.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements TextComponent {
    private List<TextComponent> lexemeList;

    public Lexeme() {
        lexemeList = new ArrayList<>();
    }

    @Override
    public void addTextComponent(TextComponent textComponent) throws InfoHandlingException {
        lexemeList.add(textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) throws InfoHandlingException {
        lexemeList.remove(textComponent);
    }

    @Override
    public void clear() throws InfoHandlingException {
        lexemeList.clear();
    }

    @Override
    public List<TextComponent> getList() throws InfoHandlingException {
        return lexemeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lexeme lexeme = (Lexeme) o;
        return lexemeList != null ? lexemeList.equals(lexeme.lexemeList) : lexeme.lexemeList == null;
    }

    @Override
    public int hashCode() {
        return lexemeList != null ? lexemeList.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        for (TextComponent textComponent : lexemeList) {
            content.append(textComponent);
        }
        return content.toString();
    }
}