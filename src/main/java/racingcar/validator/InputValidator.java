package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_CHARACTERS_REGEX = "^[a-zA-Z0-9가-힣]+$";

    public static void validateCarNames(List<String> carNames) {
        if (carNames.stream().anyMatch(InputValidator::isInvalidName)) {
            throw new IllegalArgumentException(Exception.CUSTOM_DELIMITER_FORMAT_ERROR.getValue());
        }

        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException(Exception.DUPLICATE_CAR_NAME_ERROR.getValue());
        }

        if(carNames.stream().anyMatch(InputValidator::containsInvalidCharacters)) {
            throw new IllegalArgumentException(Exception.INVALID_CHARACTERS_IN_CAR_NAME_ERROR.getValue());
        }
    }
    public static void validateTryCounts(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(Exception.POSITIVE_NUMBER_REQUIRED_ERROR.getValue());
        }
    }
    // 유효하지 않은 문자 포함 여부 체크
    private static boolean containsInvalidCharacters(String name) {
        // 한글, 영어, 숫자만 허용
        return !name.matches(INVALID_CHARACTERS_REGEX);
    }

    private static boolean isInvalidName(String name) {
        return name.isEmpty() || name.length() > MAX_NAME_LENGTH;
    }


}
