package racingcar.validation;

import java.util.List;

public class CarNameValidator {
    private final static String CAR_NAME_LENGTH_ERROR = "자동차 이름은 1~5자만 가능합니다.";
    private final static String CAR_NAMES_DUPLICATE_ERROR = "자동차 이름은 중복될 수 없습니다.";

    public static void validateCarNameLength(String input) {
        List<String> carNames = List.of(input.split(","));
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
        }
    }

    public static void validateCarNameDuplication(String input) {
        List<String> carNames = List.of(input.split(","));
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR);
        }
    }
}
