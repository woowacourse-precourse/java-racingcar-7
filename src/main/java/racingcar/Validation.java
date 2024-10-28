package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private static final String WRONG_CAR_NAME_INPUT_MESSAGE = "올바르지 못한 자동차 입력";
    private static final String WRONG_TRY_INPUT_MESSAGE = "올바르지 못한 시도 횟수";

    public static void checkCarNames(String[] carNames) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException(WRONG_CAR_NAME_INPUT_MESSAGE);
        }
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
                throw new IllegalArgumentException(WRONG_CAR_NAME_INPUT_MESSAGE);
            }
            duplicatedCarNames.add(carName);
        }
    }

    public static int checkTryCounts(String tryCounts) {
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
