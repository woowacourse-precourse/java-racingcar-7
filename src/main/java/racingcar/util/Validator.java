package racingcar.util;

public class Validator {

    private static final String ERROR = "[ERROR]";

    public void checkCarNamesInput(String carNames) {
        checkEmpty(carNames);
    }

    private void checkEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR + ", 빈 값입니다.");
        }
    }
}
