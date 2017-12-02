package by.epam.entity.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextComponent {
    private List<TextComponent> textList;

    public Text() {
        textList = new ArrayList<>();
    }

    @Override
    public void addTextComponent(TextComponent textComponent) throws InfoHandlingException {
        textList.add(textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) throws InfoHandlingException {
        textList.remove(textComponent);
    }

    @Override
    public void clear() throws InfoHandlingException {
        textList.clear();
    }

    @Override
    public List<TextComponent> getList() throws InfoHandlingException {
        return textList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        return textList != null ? textList.equals(text.textList) : text.textList == null;
    }

    @Override
    public int hashCode() {
        return textList != null ? textList.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (TextComponent textComponent : textList) {
            stringBuffer.append("\t").append(textComponent);
        }
        return stringBuffer.toString();
    }
}
