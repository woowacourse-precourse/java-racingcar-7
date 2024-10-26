package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class NameExtractor {

    private static final String REGEX = ",";

    public static List<String> getNames(String userInput) {
        List<String> rawNames = List.of(userInput.split(REGEX));
        List<String> names = new ArrayList<>();

        for (String rawName : rawNames) {
            names.add(rawName.trim());
        }

        return names;
    }
}
