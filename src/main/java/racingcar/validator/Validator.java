package racingcar.validator;


import static racingcar.util.Delimiter.COMMA;
import static racingcar.util.TryCount.MAX;
import static racingcar.util.TryCount.MIN;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.CarCountOutOfBoundsException;
import racingcar.exception.CarNameOverLengthLimitException;
import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.EmptyCarNameBetweenCommaException;
import racingcar.exception.SingleCarNameException;
import racingcar.exception.TryCountOutOfRangeException;

public class Validator {

    private final static int MAX_LENGTH_LIMIT_OF_CAR_NAME = 5;
    public final static int MAX_COUNT_LIMIT_OF_CAR = 20;

    public static void validateInputCarNamesContainComma(String inputCarNames) {
        if (!inputCarNames.contains(COMMA.getDelimiter())) {
            throw new SingleCarNameException();
        }
    }

    public static void validateAllCarNames(String carName) {

        validateCarNameOverLengthLimit(carName);
        validateEmptyCarName(carName);
    }

    private static void validateCarNameOverLengthLimit(String carName) {
        if (carName.length() > MAX_LENGTH_LIMIT_OF_CAR_NAME) {
            throw new CarNameOverLengthLimitException();
        }
    }

    private static void validateEmptyCarName(String carName) {
        if (carName.isEmpty()) {
            throw new EmptyCarNameBetweenCommaException();
        }
    }

    public static void validateCarCountLimit(List<String> carNames) {
        if (carNames.size() > MAX_COUNT_LIMIT_OF_CAR) {
            throw new CarCountOutOfBoundsException();
        }
    }

    public static void validateDuplicateCarName(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);

        if (carNames.size() > uniqueCarNames.size()) {
            throw new DuplicateCarNameException();
        }
    }

    public static void validateInputCountRange(int inputCount) {

        if (inputCount < MIN.getTryCount() || inputCount > MAX.getTryCount()) {
            throw new TryCountOutOfRangeException();
        }
    }

}
