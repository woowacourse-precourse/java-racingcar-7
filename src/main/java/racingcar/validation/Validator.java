package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int CAR_MAX_LENGTH = 5;
    private static final String ALPHA_NUMERIC_REGEX = "[a-zA-Z0-9]+";
    private static final int MOVE_ATTEMPT_COUNT_MAX = 100;
    private static final int MOVE_ATTEMPT_COUNT_MIN = 1;

    public static void validateCarNames(List<String> splitCarNames) {
        checkAlphaNumericName(splitCarNames);
        checkCarNameLength(splitCarNames);
        checkCarCount(splitCarNames);
        checkDuplicateName(splitCarNames);
    }

    public static void checkCarCount(List<String> splitCarNames) {
        if (splitCarNames.size() > 100 || splitCarNames.isEmpty()) {
            throw new IllegalArgumentException("유효한 자동차 개수는 1~100개 입니다.");
        }
    }

    public static void checkCarNameLength(List<String> splitCarNames) {
        for (String carName : splitCarNames) {
            if (carName.length() > CAR_MAX_LENGTH || carName.isEmpty()) {
                throw new IllegalArgumentException("자동차의 이름의 길이는 1~5글자입니다.");
            }
        }
    }

    public static void checkAlphaNumericName(List<String> splitCarNames) {
        for (String carName : splitCarNames) {
            if (!carName.isEmpty() && !carName.matches(ALPHA_NUMERIC_REGEX)) {
                throw new IllegalArgumentException("자동차의 이름은 영어 대소문자, 숫자로만 가능합니다.: " + carName);
            }
        }
    }

    public static void checkDuplicateName(List<String> splitCarNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : splitCarNames) {
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름은 허용하지 않습니다.");
            };
        }
    }

    public static void validateAttemptCount(int moveAttemptCount) {
        checkCountRange(moveAttemptCount);
    }

    public static int parseToInt(String userInput) {
        int moveAttemptCount;

        try {
            moveAttemptCount = Integer.parseInt(userInput);
            return moveAttemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자여야 합니다.");
        }
    }

    public static void checkCountRange(int moveAttemptCount) {
        if (moveAttemptCount < MOVE_ATTEMPT_COUNT_MIN || moveAttemptCount > MOVE_ATTEMPT_COUNT_MAX) {
            throw new IllegalArgumentException("이동시도횟수 범위는 1~100 입니다.");
        }
    }
}
