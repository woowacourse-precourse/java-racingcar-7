package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public void carNameValidate(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        if (carNames.size() > 1000) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            if(!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException();
            }

        }
    }
}
