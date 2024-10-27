package racingcar.validation;

import java.util.List;
import racingcar.message.ExceptionMessage;

public class GameValidation {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_TOO_LONG.getMessage());
        }
    }
}
