package racingcar.validator;

import java.util.List;

public class CarNameValidator {

    public void validate(List<String> carNames) {
        carNames.forEach(ValidationUtils::checkIfNotEmpty);
        checkMinimumCarNameCount(carNames);
        carNames.forEach(this::checkMaxCarNameLength);
    }

    private void checkMaxCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void checkMinimumCarNameCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상 입력이 필요합니다.");
        }
    }

}
