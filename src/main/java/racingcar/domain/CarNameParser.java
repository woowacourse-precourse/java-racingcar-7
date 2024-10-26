package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNameParser {

    private static final String EXCEPTION_EMPTY_CAR_NAME = "자동차 이름을 입력해주세요.";
    private static final String EXCEPTION_RIGHT_DELIMITER = "올바른 구분자를 입력해주세요.";
    private static final String INPUT_DELIMITER = ",";
    private static final String WRONG_DELIMITER = ".*[./].*";

    public static List<CarName> parseCarNames(String carNames) {
        validateEmptyCarNames(carNames);
        validateDelimiter(carNames);
        List<CarName> names = new ArrayList<>();

        for (String carName : splitCarNames(carNames)) {
            names.add(new CarName(carName));
        }

        return names;
    }

    private static List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(INPUT_DELIMITER));
    }

    private static void validateEmptyCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_EMPTY_CAR_NAME);
        }
    }

    private static void validateDelimiter(String carNames) {
        if (carNames.matches(WRONG_DELIMITER)) {
            throw new IllegalArgumentException(EXCEPTION_RIGHT_DELIMITER);
        }
    }
}
