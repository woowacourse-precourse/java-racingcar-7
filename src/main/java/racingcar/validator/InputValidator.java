package racingcar.validator;

public class InputValidator {

    private static final String INPUT_CAR_NAMES_REGEX = "(\\s*\\w+\\s*)(,\\s*\\w+\\s*)*";

    public static void validateCarNames(String inputCarNames) {
        if (!inputCarNames.matches(INPUT_CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("자동차 이름은 콤마로 구분해야 합니다");
        }
    }

    public static void validateTryCount(String inputTryCount) {
        try {
            Long.valueOf(inputTryCount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("시도 횟수는 아라비아 숫자로 입력해야 합니다");
        }
    }
}
