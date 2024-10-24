package racingcar.util;

import java.util.List;

public class Validator {
    public void carNameValidate(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
