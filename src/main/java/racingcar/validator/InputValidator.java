package racingcar.validator;

import racingcar.exception.CarNameException;
import racingcar.exception.CountException;

import java.util.List;

public class InputValidator {

    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank() || carName.length() > 5) {
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
