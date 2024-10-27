package racingcar.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {
    public void carNameLengthLimit5(final String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
        }
    }

    public void noDuplicateCarNames(final List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() != carNamesSet.size()) {
            throw new IllegalArgumentException("차 이름은 중복되서는 안됩니다.");
        }
    }
}
