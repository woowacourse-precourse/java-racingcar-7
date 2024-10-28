package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.config.ErrorMessages;

public class Validator {

    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣][a-zA-Z0-9가-힣]{0,4}$");
    private static final int MAX_CAR_COUNT = 100;
    private static final int MAX_ROUND_COUNT = 500;

    public static List<String> validateCarNames(String rawCarNames) {
        if (rawCarNames == null || rawCarNames.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.getMessage());
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
            throw new IllegalArgumentException(ErrorMessages.EMPTY_ROUND_COUNT.getMessage());
        }

        try {
            int roundCount = Integer.parseInt(roundCountInput);
            if (roundCount <= 0) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_ROUND_COUNT.getMessage());
            }
            if (roundCount > MAX_ROUND_COUNT) {
                throw new IllegalArgumentException("라운드 횟수는 " + MAX_ROUND_COUNT + "회를 초과할 수 없습니다.");
            }
            return roundCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
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
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NAME.getMessage());
            }
        }
    }

    private static void validateName(String name) {
        if (!CAR_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME.getMessage());
        }
    }
}
