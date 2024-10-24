package racingcar.validator;

import java.util.List;
import racingcar.exception.CarNameException;
import racingcar.exception.CountException;

public class InputValidator {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new CarNameException(carName);
            }
        }
    }

    public static void validateCount(String countInput) {
        int count;
        try {
            count = Integer.parseInt(countInput);
        } catch (IllegalStateException e) {
            throw new CountException();
        }

        if (count <= 0) {
            throw new CountException();
        }
    }
}
