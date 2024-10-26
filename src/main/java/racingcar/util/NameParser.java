package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    private static final String DELIMITER = ",";

    public static List<String> convertStringToName(String names) {
        return trimNames(parseNames(names));
    }
    public static List<String> parseNames(String names) {
        return Arrays.stream(names.split(DELIMITER)).toList();
    }

    public static List<String> trimNames(List<String> names) {
        return names.stream()
            .map(String::trim)
            .toList();
    }


}
