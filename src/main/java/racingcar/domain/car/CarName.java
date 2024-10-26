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
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CarName carName1 = (CarName) object;
        return Objects.equals(getName(), carName1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
