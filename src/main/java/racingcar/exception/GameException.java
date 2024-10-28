package racingcar.exception;

import java.util.List;

public class GameException {
    private final static String ERROR = "[ERROR] ";
    private final static int LENGTH_OF_CAR_NAME = 5;

    public void exception(final String message) {
        throw new IllegalArgumentException(ERROR + message);
    }

    public void validateCar(List<String> splitCar) {
        for (String car : splitCar) {
            validateInputIsNull(car);
            validateInputNotEmpty(car);
            validateLengthOfName(car);
        }
    }

    private void validateInputIsNull(String car) {
        if (car == null) {
            exception("차 이름은 null이 될 수 없습니다.");
        }
    }

    private void validateInputNotEmpty(String car) {
        if (car.trim().isEmpty()) {
            exception("차 이름은 공백으로 할 수 없습니다.");
        }
    }

    private void validateLengthOfName(String car) {
        if (car.length() > LENGTH_OF_CAR_NAME) {
            exception("차 이름은 5자 이하여야 합니다.");
        }
    }

    public void validateTryCount(String input) {
        try {
            if (input.trim().isEmpty()) {
                exception("시도할 횟수는 공백이 될 수 없습니다.");
            }

            long count = Long.parseLong(input);

            if (count <= 0) {
                exception("레이싱은 음수나 0이 될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            exception("시도할 횟수는 숫자여야 합니다.");
        }
    }
}
