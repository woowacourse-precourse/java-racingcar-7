package racingcar.validator;

public class InputValidator {

    private static final int CAR_NAME_LIMIT_LENGTH = 5;

    public void validateCarNameLength(final String name) {
        if (name == null || name.isBlank() || name.length() > CAR_NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 존재해야하며 5자 이하만 가능합니다.");
        }
    }

    public void validateTryCountGreaterZero(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야됩니다.");
        }
    }
}
