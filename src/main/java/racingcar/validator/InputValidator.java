package racingcar.validator;

import java.util.List;
import racingcar.exception.CarNameDuplicatedException;
import racingcar.exception.CarNameException;
import racingcar.exception.CountException;

public class InputValidator {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        validateCarNameFormat(carNames);
        validateDuplicatedCarName(carNames);
    }

    private static void validateCarNameFormat(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new CarNameException(carName);
            }
        }
    }

    private static void validateDuplicatedCarName(List<String> carNames) {
        long deduplicatedSize = carNames.stream().distinct().count();
        if (carNames.size() != deduplicatedSize) {
            throw new CarNameDuplicatedException();
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
