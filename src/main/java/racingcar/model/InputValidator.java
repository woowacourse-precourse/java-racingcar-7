package racingcar.model;

import racingcar.common.RegexUtils;

import java.util.Arrays;

public class InputValidator {
    private static final String BLANK_IS_NOT_ALLOWED = "입력은 공백일 수 없습니다.";
    private static final String SPECIAL_CHAR_IS_NOT_ALLOWED = "유효하지 않은 특수문자입니다.";
    private static final String LENGTH_IS_TOO_LONG = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String IS_NOT_NUMBER = "숫자만 입력 가능합니다.";

    public void validateCarNames(String input) {
        checkBlack(input);
        checkSpecialChar(input);
        checkCarNameLength(input);
    }

    public void validateTryCounts(String input) {
        checkNumber(input);
    }

    private void checkNumber(String input) {
        if (!RegexUtils.isContainOnlyNumber(input)) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    private void checkBlack(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_IS_NOT_ALLOWED);
        }
    }

    private void checkSpecialChar(String input) {
        if (!RegexUtils.isContainSpecialChar(input)) {
            throw new IllegalArgumentException(SPECIAL_CHAR_IS_NOT_ALLOWED);
        }
    }

    private void checkCarNameLength(String input) {
        if (!areAllCarNamesUnderSix(input)) {
            throw new IllegalArgumentException(LENGTH_IS_TOO_LONG);
        }
    }

    private boolean areAllCarNamesUnderSix(String input) {
        return Arrays.stream(input.split(","))
                .allMatch(carName -> carName.length() <= 5);
    }
}
