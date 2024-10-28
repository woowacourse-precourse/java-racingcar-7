package domain.car;

import java.util.Objects;
import racingcar.enums.ErrorMessage;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private CarName(final String name) {
        this.name = name.trim();
        validateCarName(this.name);
    }

    public static CarName from(final String name) {
        return new CarName(name);
    }

    public String getName() {
        return this.name;
    }

    private void validateCarName(final String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarName carName = (CarName) obj;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
