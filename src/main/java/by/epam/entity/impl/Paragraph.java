package by.epam.entity.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {
    private List<TextComponent> paragraphList;

    public Paragraph() {
        paragraphList = new ArrayList<>();
    }

    @Override
    public void addTextComponent(TextComponent textComponent) throws InfoHandlingException {
        paragraphList.add(textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) throws InfoHandlingException {
        paragraphList.remove(textComponent);
    }

    @Override
    public void clear() throws InfoHandlingException {
        paragraphList.clear();
    }

    @Override
    public List<TextComponent> getList() throws InfoHandlingException {
        return paragraphList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        return paragraphList != null ? paragraphList.equals(paragraph.paragraphList) : paragraph.paragraphList == null;
    }

    @Override
    public int hashCode() {
        return paragraphList != null ? paragraphList.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (TextComponent textComponent : paragraphList) {
            stringBuffer.append(textComponent).append("\n");
        }
        return stringBuffer.toString();
    }
}


