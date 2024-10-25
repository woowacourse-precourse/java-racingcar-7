package racingcar.validator;

import java.util.List;

import static java.lang.String.format;
import static racingcar.utils.CarNameParser.NAME_DELIMITER;

public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateEndsWithDelimiter(String input) {
        if (isEndsWithDelimiter(input)) {
            throw new IllegalArgumentException(format("[ERROR] 입력 값은 구분자(%s)로 끝날 수 없습니다.", NAME_DELIMITER));
        }
    }

    public static void validateLength(String name) {
        if (isInvalidLength(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    public static void validateDuplicate(List<String> carNames) {
        if (isDuplicate(carNames)) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 존재합니다.");
        }
    }

    private static boolean isEndsWithDelimiter(String input) {
        return input.endsWith(NAME_DELIMITER);
    }

    private static boolean isInvalidLength(String name) {
        return name.isEmpty() || name.length() > MAX_CAR_NAME_LENGTH;
    }

    private static boolean isDuplicate(List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }

}
