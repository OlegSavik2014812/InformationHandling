package by.epam.entity.impl;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {
    private List<TextComponent> sentenceList;

    public Sentence() {
        sentenceList = new ArrayList<>();
    }

    @Override
    public void addTextComponent(TextComponent textComponent) throws InfoHandlingException {
        sentenceList.add(textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) throws InfoHandlingException {
        sentenceList.remove(textComponent);
    }

    @Override
    public void clear() throws InfoHandlingException {
        sentenceList.clear();
    }

    @Override
    public List<TextComponent> getList() throws InfoHandlingException {
        return sentenceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        return sentenceList != null ? sentenceList.equals(sentence.sentenceList) : sentence.sentenceList == null;
    }

    @Override
    public int hashCode() {
        return sentenceList != null ? sentenceList.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (TextComponent textComponent : sentenceList) {
            stringBuffer.append(textComponent).append(" ");
        }
        return stringBuffer.toString();
    }
}

