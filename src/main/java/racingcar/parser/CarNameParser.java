package racingcar.parser;

import static racingcar.common.Constant.DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {

    public List<String> parseAndTrimCarNames(String input) {
        return trimCarNames(splitCarNames(input));
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(DELIMITER.getValue()));
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
