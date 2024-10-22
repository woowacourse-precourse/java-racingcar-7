package racingcar.validator;

public class InputValidator {

    public void validateCarNameLength(final String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 존재해야하며 5자 이하만 가능합니다.");
        }
    }

    public void validateTryCountGreaterZero(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야됩니다.");
        }
    }
}
