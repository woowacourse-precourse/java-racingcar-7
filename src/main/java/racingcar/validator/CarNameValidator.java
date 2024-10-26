package racingcar.validator;

import java.util.List;

import static java.lang.String.format;
import static racingcar.utils.CarNameParser.NAME_DELIMITER;

public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateInput(final String input) {
        validateEndsWithDelimiter(input);
    }

    public static void validateCarName(final String name) {
        validateCarNameLength(name);
        validateContainsBlank(name);
    }

    public static void validateCarNamesList(final List<String> carNames) {
        validateDuplicate(carNames);
    }

    private static void validateContainsBlank(final String name) {
        if (isContainsBlank(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에는 공백이 포함될 수 없습니다.");
        }
    }

    private static void validateEndsWithDelimiter(final String input) {
        if (isEndsWithDelimiter(input)) {
            throw new IllegalArgumentException(format("[ERROR] 입력 값은 구분자(%s)로 끝날 수 없습니다.", NAME_DELIMITER));
        }
    }

    private static void validateCarNameLength(final String name) {
        if (isInvalidLength(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private static void validateDuplicate(final List<String> carNames) {
        if (isDuplicate(carNames)) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 존재합니다.");
        }
    }

    private static boolean isEndsWithDelimiter(final String input) {
        return input.endsWith(NAME_DELIMITER);
    }

    private static boolean isInvalidLength(final String name) {
        return name.isEmpty() || name.length() > MAX_CAR_NAME_LENGTH;
    }

    private static boolean isDuplicate(final List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }

    private static boolean isContainsBlank(final String name) {
        return name.contains(" ");
    }

}
