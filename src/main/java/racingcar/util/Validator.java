package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣][a-zA-Z0-9가-힣]{0,4}$");
    private static final String EMPTY_INPUT_ERROR = "자동차 이름을 반드시 입력해야 합니다.";
    private static final String INVALID_NAME_ERROR = "잘못된 입력입니다. 자동차 이름은 1~5자 사이의 유효한 문자로 구성되어야 합니다.";
    private static final String EMPTY_ROUND_COUNT_ERROR = "라운드 횟수를 반드시 입력해야 합니다.";
    private static final String INVALID_ROUND_COUNT_ERROR = "라운드 횟수는 1 이상의 숫자여야 합니다.";
    private static final String INVALID_NUMBER_FORMAT_ERROR = "올바른 숫자를 입력해야 합니다.";
    private static final String DUPLICATE_NAME_ERROR = "자동차 이름에 중복이 있습니다: '%s'";
    private static final int MAX_CAR_COUNT = 100;
    private static final int MAX_ROUND_COUNT = 500;

    public static List<String> validateCarNames(String rawCarNames) {
        if (rawCarNames == null || rawCarNames.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }

        List<String> carNames = Arrays.stream(rawCarNames.split(","))
                .map(String::trim)
                .peek(Validator::validateName)
                .toList();

        checkDuplicates(carNames);
        validateCarCount(carNames);

        return carNames;
    }

    public static int validateRoundCount(String roundCountInput) {
        if (roundCountInput == null || roundCountInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ROUND_COUNT_ERROR);
        }

        try {
            int roundCount = Integer.parseInt(roundCountInput);
            if (roundCount <= 0) {
                throw new IllegalArgumentException(INVALID_ROUND_COUNT_ERROR);
            }
            if (roundCount > MAX_ROUND_COUNT) {
                throw new IllegalArgumentException("라운드 횟수는 " + MAX_ROUND_COUNT + "회를 초과할 수 없습니다.");
            }
            return roundCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR);
        }
    }

    private static void validateCarCount(List<String> carNames) {
        if (carNames.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 개수는 " + MAX_CAR_COUNT + "대를 초과할 수 없습니다.");
        }
    }

    private static void checkDuplicates(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, name));
            }
        }
    }

    private static void validateName(String name) {
        if (!CAR_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }
}
