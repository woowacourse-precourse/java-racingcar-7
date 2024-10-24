package racingcar.validation;

import static racingcar.util.Constant.MAX_CAR_NAME_LENGTH;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator implements NameValidator {

    @Override
    public void validate(Collection<String> carNames) {
        validateEmptyOrBlank(carNames);
        validateDuplicateNames(carNames);
        validateNameLength(carNames);
    }

    private void validateEmptyOrBlank(Collection<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 값이나 공백일 수 없습니다.");
            }

            if (carNames.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
            }
        }
    }

    private void validateDuplicateNames(Collection<String> carNames) {
        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNames.size() != carNameSet.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateNameLength(Collection<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
