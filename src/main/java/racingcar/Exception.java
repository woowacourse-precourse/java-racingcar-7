package racingcar;

public class Exception {
    private static final String MUST_BE_5_CHARACTERS_OR_LESS = "자동차 이름이 5글자 이하여야 합니다.";
    private static final int MAX_LENGTH = 5;

    public static void validateLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MUST_BE_5_CHARACTERS_OR_LESS);
        }
    }
}
