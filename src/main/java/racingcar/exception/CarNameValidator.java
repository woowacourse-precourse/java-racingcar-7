package racingcar.exception;

public class CarNameValidator {

    public void validateCarName(String[] input) {
        for (String carName : input) {
            validateCarNameLength(carName);
            validateCarNameEmpty(carName);
            validateCarNameDelimiter(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void validateCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public void validateCarNameDelimiter(String carNames) {
        if (!carNames.matches("^[a-zA-Z0-9,]*$")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로만 구분되어야 합니다.");
        }
    }
}
