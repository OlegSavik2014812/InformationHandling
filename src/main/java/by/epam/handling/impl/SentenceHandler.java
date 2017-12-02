package by.epam.handling.impl;

import by.epam.handling.ComponentHandler;
import by.epam.conversion.ExpressionConverter;
import by.epam.entity.TextComponent;
import by.epam.entity.impl.Sentence;
import by.epam.exception.InfoHandlingException;
import by.epam.interpreter.Interpreter;
import by.epam.parsing.ComponentParser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements ComponentHandler {
    private TextComponent sentence;
    private static int i;
    private static int j;

    private final static String MATH_REGEX = "(?:[\\d+/*()]|-(?!\\p{Blank}|$)|\\.(?=\\d))+(?!\\w)";
    private final static String LEXEME_REGEX = "\\S+\n?";
    private final static String VALUE_OF_I_REGEX = "[i][=](\\d*[.]?\\d*)";
    private final static String VALUE_OF_J_REGEX = "[j][=](\\d*[.]?\\d*)";
    private final static String INCREMENT_AFTER_I_REGEX = "\\s?[i][+][+]\\s?";
    private final static String INCREMENT_BEFORE_I_REGEX = "\\s?[+][+][i]\\s?";
    private final static String DECREMENT_AFTER_I_REGEX = "\\s?[i][-][-]\\s?";
    private final static String DECREMENT_BEFORE_I_REGEX = "\\s?[-][-][i]\\s?";
    private final static String INCREMENT_AFTER_J_REGEX = "\\s?[j][+][+]\\s?";
    private final static String INCREMENT_BEFORE_J_REGEX = "\\s?[+][+][j]\\s?";
    private final static String DECREMENT_AFTER_J_REGEX = "\\s?[j][-][-]\\s?";
    private final static String DECREMENT_BEFORE_J_REGEX = "\\s?[-][-][j]\\s?";

    private static int setVariableI(String word) {
        String mass[] = word.split("=");
        return SentenceHandler.i = Integer.parseInt(mass[1]);
    }

    private static int setVariableJ(String word) {
        String mass[] = word.split("=");
        return SentenceHandler.j = Integer.parseInt(mass[1]);
    }


    public SentenceHandler() {
        sentence = new Sentence();
    }

    @Override
    public TextComponent handle(String sentence) throws InfoHandlingException {
        List<String> words = ComponentParser.parse(sentence, LEXEME_REGEX);

        Pattern patternMath = Pattern.compile(MATH_REGEX);
        Pattern patternIncrementAfterI = Pattern.compile(INCREMENT_AFTER_I_REGEX);
        Pattern patternIncrementBeforeI = Pattern.compile(INCREMENT_BEFORE_I_REGEX);
        Pattern patternDecrementAfterI = Pattern.compile(DECREMENT_AFTER_I_REGEX);
        Pattern patternDecrementBeforeI = Pattern.compile(DECREMENT_BEFORE_I_REGEX);
        Pattern patternIncrementAfterJ = Pattern.compile(INCREMENT_AFTER_J_REGEX);
        Pattern patternIncrementBeforeJ = Pattern.compile(INCREMENT_BEFORE_J_REGEX);
        Pattern patternDecrementAfterJ = Pattern.compile(DECREMENT_AFTER_J_REGEX);
        Pattern patternDecrementBeforeJ = Pattern.compile(DECREMENT_BEFORE_J_REGEX);
        Pattern patternI = Pattern.compile(VALUE_OF_I_REGEX);
        Pattern patternJ = Pattern.compile(VALUE_OF_J_REGEX);

        for (String word : words) {
            Matcher matcherI = patternI.matcher(word);
            Matcher matcherJ = patternJ.matcher(word);
            Matcher matcherIncrementAfterI = patternIncrementAfterI.matcher(word);
            Matcher matcherIncrementBeforeI = patternIncrementBeforeI.matcher(word);
            Matcher matcherDecrementAfterI = patternDecrementAfterI.matcher(word);
            Matcher matcherDecrementBeforeI = patternDecrementBeforeI.matcher(word);
            Matcher matcherIncrementAfterJ = patternIncrementAfterJ.matcher(word);
            Matcher matcherIncrementBeforeJ = patternIncrementBeforeJ.matcher(word);
            Matcher matcherDecrementAfterJ = patternDecrementAfterJ.matcher(word);
            Matcher matcherDecrementBeforeJ = patternDecrementBeforeJ.matcher(word);
            if (matcherI.find()) {
                i = setVariableI(word);
            }
            if (matcherJ.find()) {
                j = setVariableJ(word);
            }
            if (matcherIncrementAfterI.find()) {
                word = word.replace("i++", replaceIncrement(i));
            }
            if (matcherIncrementBeforeI.find()) {
                word = word.replace("++i", replaceIncrement(i));
            }
            if (matcherDecrementAfterI.find()) {
                word = word.replace("i--", replaceDecrement(i));
            }
            if (matcherDecrementBeforeI.find()) {
                word = word.replace("--i", replaceDecrement(i));
            }
            if (matcherIncrementAfterJ.find()) {
                word = word.replace("j++", replaceIncrement(j));
            }
            if (matcherIncrementBeforeJ.find()) {
                word = word.replace("++j", replaceIncrement(j));
            }
            if (matcherDecrementAfterJ.find()) {
                word = word.replace("j--", replaceDecrement(j));
            }
            if (matcherDecrementBeforeJ.find()) {
                word = word.replace("--j", replaceDecrement(j));
            }


            Matcher m = patternMath.matcher(word);
            if (m.find()) {
                String expression = m.group();
                String postfix = ExpressionConverter.convertToPostfix(expression);
                Interpreter interpreter = new Interpreter();
                String result = String.format("%.2f", interpreter.calculate(postfix).doubleValue());
                word = word.replace(expression, result);
            }
            this.sentence.addTextComponent(new LexemeHandler().handle(word));
        }
        return this.sentence;
    }

    private String replaceIncrement(int number) {
        int value = number;
        return String.valueOf(++value);
    }

    private String replaceDecrement(int number) {
        int value = number;
        return String.valueOf(--value);
    }
}
