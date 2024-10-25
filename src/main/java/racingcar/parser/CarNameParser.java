package racingcar.parser;

import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {

    private static final String DELIMITER = ",";

    public List<String> parseAndTrimCarNames(String input) {
        return trimCarNames(splitCarNames(input));
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(DELIMITER));
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
