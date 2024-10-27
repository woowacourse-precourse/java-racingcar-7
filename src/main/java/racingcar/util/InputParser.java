package racingcar.util;

import java.util.List;
import racingcar.validator.InputValidator;

public class InputParser {

    private static final String DELIMITER = ",";

    public static List<String> parseCarNames(String carNames) {
        List<String> carNameList = List.of(carNames.split(DELIMITER));
        InputValidator.validateCarNames(carNameList);
        return carNameList;
    }

    public static int parseTryCount(String tryCount) {
        InputValidator.validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }
}
