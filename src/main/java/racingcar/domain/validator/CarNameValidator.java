package racingcar.domain.validator;

public class CarNameValidator {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    public void validate(String name) {
        validateNull(name);
        validateLength(name);
    }

    private void validateNull(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}