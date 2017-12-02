package by.epam.service.sorter;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;
import by.epam.service.BaseAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SentenceSorter extends BaseAction {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public List<TextComponent> realize(TextComponent textComponent) throws InfoHandlingException {
        List<TextComponent> allSentences = getAllSentences(textComponent);
        allSentences.sort(new SentenceComparator());
        for (TextComponent allSentence : allSentences) {
            LOGGER.info(allSentence + "[" + "quantity of lexemes is " + allSentence.getList().size() + "]" + "\n");
        }
        return allSentences;
    }
}
