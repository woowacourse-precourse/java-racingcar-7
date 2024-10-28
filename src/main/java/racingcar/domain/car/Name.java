package racingcar.domain.car;

import static racingcar.constant.GameConstants.MAX_NAME_LENGTH;
import static racingcar.constant.GameConstants.MIN_NAME_LENGTH;

import racingcar.exception.car.InvalidCarNameException.NameLengthExceededExceptionInvalid;
import racingcar.exception.car.InvalidCarNameException.NameLengthShortExceptionInvalid;

public class Name {
    private final String value;

    private Name(String value) {
        validate(value);
        this.value = value;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        validateNull(name);
        validateMinLength(name);
        validateMaxLength(name);
    }

    public String getValue() {
        return this.value;
    }

    private void validateMinLength(String name) {
        if (isSmallerThenNAME_MIN_LENTH(name)) {
            throw new NameLengthShortExceptionInvalid();
        }
    }

    private void validateMaxLength(String name) {
        if (isBiggerThenNAME_MAX_LENTH(name)) {
            throw new NameLengthExceededExceptionInvalid();
        }
    }

    private void validateNull(String name) {
        if (isNull(name)) {
            throw new NullPointerException();
        }
    }

    private boolean isSmallerThenNAME_MIN_LENTH(String name) {
        return name.length() < MIN_NAME_LENGTH;
    }

    private boolean isBiggerThenNAME_MAX_LENTH(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private boolean isNull(String name) {
        return name == null;
    }

}
