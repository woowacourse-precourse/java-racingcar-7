package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String ERROR_INVALID_DELIMITER_MESSAGE = "구분자는 처음과 끝에 존재할 수 없습니다.";
    private static final String DELIMITER = ",";
    private static final String ERROR_INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 양수여야 합니다.";
    private static final int MIN_TRY_COUNT = 1;

    public static List<String> parseCarNames(String carNames) {
        validateCarNames(carNames);
        return Arrays.stream(carNames.split(DELIMITER)).toList();
    }

    private static void validateCarNames(String carNames) {
        if (carNames.startsWith(DELIMITER) || carNames.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER_MESSAGE);
        }
    }

    public static Integer parseTryCount(String tryCountString) {
        int tryCount = Integer.parseInt(tryCountString);
        validateTryCount(tryCount);
        return tryCount;
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_TRY_COUNT_MESSAGE);
        }
    }
}
