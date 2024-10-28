package racingcar.Validation;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final String EXCEPTION_SPECIAL_CHARACTERS = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";
    private static final String ERROR_SINGLE_PARTICIPANT = "참가자는 최소 2명 이상이어야 합니다.";
    private static final String ERROR_EMPTY_INPUT = "입력 값은 비어 있을 수 없습니다.";
    private static final String ERROR_TRAILING_COMMA = "입력 값의 끝에 쉼표가 올 수 없습니다.";
    private static final String ERROR_DUPLICATE_NAMES = "참가자 이름은 중복될 수 없습니다.";
    private static final String ERROR_SPECIAL_CHARACTERS = "자동차 이름에는 특수문자가 포함될 수 없습니다.";
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 5글자 이하이어야 합니다.";

    public static void validate(String input) {
        validateInputFormat(input);
        validateCarNames(input.split(","));
    }

    private static void validateInputFormat(String input) {
        checkEmptyInput(input);
        checkTrailingComma(input);
    }

    private static void validateCarNames(String[] carNames) {
        checkSingleParticipant(carNames);
        checkDuplicateNames(carNames);
        for (String name : carNames) {
            validateCarName(name.trim());
        }
    }

    private static void checkEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    private static void checkTrailingComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_TRAILING_COMMA);
        }
    }

    private static void checkSingleParticipant(String[] carNames) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException(ERROR_SINGLE_PARTICIPANT);
        }
    }

    private static void checkDuplicateNames(String[] carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            if (!nameSet.add(name.trim())) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES);
            }
        }
    }

    private static void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameSpecialCharacters(carName);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private static void validateCarNameSpecialCharacters(String carName) {
        if (carName.matches(EXCEPTION_SPECIAL_CHARACTERS)) {
            throw new IllegalArgumentException(ERROR_SPECIAL_CHARACTERS);
        }
    }
}
