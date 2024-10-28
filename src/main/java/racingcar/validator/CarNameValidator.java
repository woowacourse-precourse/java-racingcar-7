package racingcar.validator;

import static racingcar.validator.ErrorMessages.INVALID_CAR_NAME_MAX_LENGTH;
import static racingcar.validator.ErrorMessages.INVALID_CAR_NAME_MIN_LENGTH;
import static racingcar.validator.ErrorMessages.INVALID_DUPLICATE_CAR_NAME;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.util.SplitterUtil;

public class CarNameValidator {

    public static void validateDuplicateCarNames(String carNames) {
        String[] splitCarNames = SplitterUtil.splitCarNames(carNames);
        List<String> carNameList = Arrays.asList(splitCarNames);
        int uniqueCarNames = new HashSet<>(carNameList).size();

        if (uniqueCarNames != carNameList.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public static void validateCarName(String carName) {
        validateMinNameLength(carName);
        validateMaxNameLength(carName);
    }

    private static void validateMaxNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MAX_LENGTH.getMessage());
        }
    }

    private static void validateMinNameLength(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MIN_LENGTH.getMessage());
        }
    }

}
