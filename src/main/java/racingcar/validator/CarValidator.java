package racingcar.validator;

import java.util.List;
import static racingcar.utils.CarErrorMessage.*;

public class CarValidator {

    private final int MAX_CAR_NAME_LENGTH = 5;

    public void validateInputCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_CAR_NAMES);
        }
    }

    public void validateAllCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateCarName(name);
        }
    }

    public void validateCarName(String CarName) {

        if (CarName == null || CarName.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_CAR_NAME);
        }
        if (CarName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG + CarName);
        }
    }

}
