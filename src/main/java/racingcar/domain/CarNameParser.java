package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNameParser {

    private static final String INPUT_DELIMITER = ",";

    public static List<CarName> parseCarNames(String carNames) {
        validateEmptyCarNames(carNames);
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
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }
}
