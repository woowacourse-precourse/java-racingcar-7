package racingcar.validation;

import java.util.List;

public class CarNameValidator {
    public void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateSingleCarName(name);
        }
    }

    private void validateSingleCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
        }
    }
}