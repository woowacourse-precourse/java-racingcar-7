package racingcar.domain.car;

import static racingcar.config.GameConfig.CAR_NAME_VALIDATION_PATTERN;
import static racingcar.config.GameConfig.MAX_NAME_LENGTH;
import static racingcar.utils.ExceptionConstants.CAR_NAME_TOO_LONG;
import static racingcar.utils.ExceptionConstants.INVALID_CAR_NAME_ERROR;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateCarNameLength(name);
        validateCarNameFormat(name);
        this.name = name;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getErrorMessage());
        }
    }

    private void validateCarNameFormat(String carName) {
        if (!carName.matches(CAR_NAME_VALIDATION_PATTERN)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        return this == object || (object instanceof CarName && Objects.equals(getName(), ((CarName) object).getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
