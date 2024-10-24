package racingcar.parser;

import java.util.Arrays;
import java.util.List;

public class CarNamesParser {

    private static final String CAR_NAMES_DELIMITER = ",";

    public static List<String> parseCarNames(final String input) {
        return Arrays
                .stream(input.split(CAR_NAMES_DELIMITER))
                .toList();
    }
}