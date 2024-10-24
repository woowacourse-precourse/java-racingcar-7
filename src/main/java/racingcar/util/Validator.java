package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final String PRINTABLE_PATTERN = "\\p{Print}+";
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
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException();
            }
            if (!carName.matches(VALID_NAME_PATTERN)) {
                throw new IllegalArgumentException();
            }
            if (!carName.matches(PRINTABLE_PATTERN)) {
                throw new IllegalArgumentException();
            }

        }
    }
}
