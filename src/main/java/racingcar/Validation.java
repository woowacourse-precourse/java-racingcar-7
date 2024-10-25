package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private static final String WRONG_CAR_NAME_INPUT_MESSAGE = "올바르지 못한 자동차이름";
    private static final String WRONG_TRY_INPUT_MESSAGE = "올바르지 못한 시도 횟수";
    private static final String DUPLICATE_CAR_NAME_MESSAGE = "중복된 자동차이름";

    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException(WRONG_CAR_NAME_INPUT_MESSAGE);
            }
        }
        checkForDuplication(carNames);
    }

    private static void checkForDuplication(String[] carNames) {

        List<String> duplicatedCarNames = new ArrayList<>();
        for (String carName : carNames) {
            if (duplicatedCarNames.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
            }
            duplicatedCarNames.add(carName);
        }
    }

    public static int validateTryCounts(String tryCounts) {
        int counts;
        try {
            counts = Integer.parseInt(tryCounts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_TRY_INPUT_MESSAGE);
        }
        if (counts <= 0) {
            throw new IllegalArgumentException(WRONG_TRY_INPUT_MESSAGE);
        }
        return counts;
    }
}
