package racingcar.domain.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesValidator {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "유효하지 않은 입력값 입니다. %s. 입력값: %s";
    private static final String INVALID_LENGTH_MESSAGE = "자동차 이름 길이는 %d 이상 %d 이하만 가능합니다"
            .formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private static final String DUPLICATED_MESSAGE = "중복된 이름은 존재할 수 없습니다";

    private static final String EMPTY_NAME_MESSAGE = "자동차 이름은 빈 값일 수 없습니다";

    private CarNamesValidator() {
    }

    public static void validate(List<String> names) {
        validateNameLength(names);
        validateNameUniqueness(names);
        validateNotEmpty(names);
    }

    private static void validateNameLength(List<String> names) {
        for (String name : names) {
            if (!isValidNameLength(name)) {
                throw new IllegalArgumentException(
                        ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(INVALID_LENGTH_MESSAGE, name));
            }
        }
    }

    private static boolean isValidNameLength(String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    private static void validateNameUniqueness(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(DUPLICATED_MESSAGE, names));
        }
    }

    private static void validateNotEmpty(List<String> names) {
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(
                        ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(EMPTY_NAME_MESSAGE, names));
            }
        }
    }
}
