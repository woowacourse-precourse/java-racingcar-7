package racingcar.domain;

import java.util.List;

public class InputParser {

    private static final String INPUT_DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parserCarNames(String userInput) {
        return List.of(userInput.split(INPUT_DELIMITER));
    }

}
