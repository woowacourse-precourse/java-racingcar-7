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
        checkEmptyInput(input);
        checkTrailingComma(input);
        String[] carNames = input.split(",");
        checkSingleParticipant(carNames);
        checkDuplicateNames(carNames);
        for (String name : carNames) {
            validateCarNameLength(name.trim());
            validateCarNameSpecialCharacters(name.trim());
        }
    }

    //입력이 공백인지 확인
    private static void checkEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }
    //마지막 입력이,로 들어오면 예외처리
    private static void checkTrailingComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_TRAILING_COMMA);
        }
    }

    //car가 1개라면 예외처리
    private static void checkSingleParticipant(String[] carNames) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException(ERROR_SINGLE_PARTICIPANT);
        }
    }
    //중복된 이름이 들어오면 예외처리
    private static void checkDuplicateNames(String[] carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            if (!nameSet.add(name.trim())) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES);
            }
        }
    }


    //이름이 5자 이상이면 예외
    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }
    //특수문자가 들어오면 예외
    private static void validateCarNameSpecialCharacters(String carName) {
        if (carName.matches(EXCEPTION_SPECIAL_CHARACTERS)) {
            throw new IllegalArgumentException(ERROR_SPECIAL_CHARACTERS);
        }
    }
}
