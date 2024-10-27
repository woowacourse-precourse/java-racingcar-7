package racingcar.domain.car;

import static racingcar.utils.ExceptionConstants.CAR_NAME_TOO_LONG;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateUserNameLength(name);
        this.name = name;
    }

    private void validateUserNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getErrorMessage());
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
