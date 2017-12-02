package by.epam.service.sorter;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;

import java.util.Comparator;

public class SentenceComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent previousComponent, TextComponent nextComponent) {
        try {
            int previousSize = previousComponent.getList().size();
            int nextSize = nextComponent.getList().size();
            return Integer.compare(previousSize, nextSize);
        } catch (InfoHandlingException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
