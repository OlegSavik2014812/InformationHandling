package by.epam.service.counter;

import by.epam.entity.TextComponent;
import by.epam.exception.InfoHandlingException;
import by.epam.service.BaseAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SentenceCounter extends BaseAction {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Integer realize(TextComponent textComponent) throws InfoHandlingException {
        int counter = 0;
        boolean label;
        List<TextComponent> sentences = getAllSentences(textComponent);
        for (TextComponent sentence : sentences) {
            label = false;
            for (int i = 0; i < sentence.getList().size(); i++) {
                if (!label) {
                    for (int j = sentence.getList().size() - 1; j >= 0; j--) {
                        if (sentence.getList().get(i).equals(sentence.getList().get(j)) && i != j) {
                            counter++;
                            label = true;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        LOGGER.info("\n" + "Quantity of sentences with similar lexemes is " + counter + "\n");
        return counter;
    }
}



