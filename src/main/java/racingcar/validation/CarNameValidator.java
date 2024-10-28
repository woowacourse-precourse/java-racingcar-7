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
}
