package racingcar.validation;

import java.util.List;

public class CarNameValidator {
    private CarNameValidator() {
    }

    public static void validateCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() >= 6) {
                throw new IllegalArgumentException("길이가 6 이상 자동차 이름이 포함되어 있습니다.");
            }
        }
    }

    public static void validateTrimmedInput(String trimmedInput) {
        if (trimmedInput.length() == 0) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }

    public static void validateCarNamesCount(List<String> carNames) {
        if (carNames.size() == 0) {
            throw new IllegalArgumentException("구분자를 제외한 자동차 이름이 입력되지 않았습니다.");
        }
    }
}
