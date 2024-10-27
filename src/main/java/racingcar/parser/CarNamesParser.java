package racingcar.parser;

import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class CarNamesParser {

    private static final String CAR_NAMES_DELIMITER = ",";

    public static List<String> parseCarNames(final String input) {
        List<String> names = getCarNames(input);
        InputValidator.validateDuplicate(names);
        return names;
    }

    private static List<String> getCarNames(final String input) {
        return Arrays.stream(input.split(CAR_NAMES_DELIMITER))
                .map(String::trim)
                .filter(name -> !name.isBlank())
                .toList();
    }
}