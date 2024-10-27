package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String DELIMITER = ",";
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    public static List<String> validateCarNames(final String input) {
        List<String> carNames = List.of(input.split(DELIMITER));
        if (!haveValidLength(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분하여 비어 있지 않고 1자에서 5자 사이여야 합니다.");
        }
        if (hasDuplicates(carNames)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
        return carNames;
    }

    public static int validateAttemptCount(final String attemptCount) {
        if (!attemptCount.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
        return Integer.parseInt(attemptCount);
    }

    private static boolean haveValidLength(List<String> carNames) {
        return carNames.size() > 0 && carNames.stream()
                .allMatch(carName -> carName.length() >= 1 && carName.length() <= 5);
    }

    private static boolean hasDuplicates(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        return uniqueNames.size() < carNames.size();
    }
}
