package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplit {

    private static final String SEPARATOR = ",";

    public static List<String> stringSplitBySeparator(String nameString) {
        if (nameString == null || nameString.trim().isEmpty()) {
            return List.of();
        }

        return Arrays.stream(nameString.split(SEPARATOR, -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
