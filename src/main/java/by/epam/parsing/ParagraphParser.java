package by.epam.parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphParser {
    public static List<String> parse(String text, String regex) {
        String[] strings = text.split(regex);
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList(strings));
        stringList.remove(0);
        return stringList;
    }
}

