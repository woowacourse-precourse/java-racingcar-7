package racingcar;

public class Validator {
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하이어야 합니다.";

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            validateCarNameLength(name);
        }
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
