package racingcar.validator;

import racingcar.validator.exception.InvalidCarNameException;

public class CarNameValidator implements Validator<String> {
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String name) {
        validateNotBlank(name);
        validateNameLength(name);
    }

    private void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidCarNameException("차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidCarNameException("차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
