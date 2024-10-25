package racingcar.model.dependency.validator;

import racingcar.exception.ExceptionFactory;

import static racingcar.exception.ExceptionType.*;

public class DefaultRacingCarValidator implements RacingCarValidator {

    private final int MAX_NAME_LENGTH = 5;

    @Override
    public void validateName(String name) {
        if (name == null) {
            throw ExceptionFactory.createException(NAME_CANNOT_BE_NULL);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw ExceptionFactory.createException(NAME_TOO_LONG, MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
        if (name.isBlank()) {
            throw ExceptionFactory.createException(NAME_CANNOT_BE_BLANK);
        }
    }
}
