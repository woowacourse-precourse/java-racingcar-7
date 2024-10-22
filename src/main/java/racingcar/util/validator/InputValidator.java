package racingcar.util.validator;

public class InputValidator {

    private static final String CAR_NAMES_REGEX = "[가-힣|a-zA-Z]{1,5}(,[가-힣|a-zA-Z]{1,5})*";

    public static void validateCarNames(String input) {
        if (!input.matches(CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 올바른 자동차 이름을 입력해주세요");
        }
    }
}
