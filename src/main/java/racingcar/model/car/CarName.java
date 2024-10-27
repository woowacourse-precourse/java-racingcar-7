package racingcar.model.car;

import static racingcar.common.Error.NAME_CANNOT_EXCEED_MAX_LENGTH;
import static racingcar.common.Error.NOT_NULL_OR_EMPTY_NAME;

public class CarName {
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validateIsPresent(name);
        validateName(name);
        return new CarName(name);
    }

    public String getName() {
        return name;
    }

    private static void validateIsPresent(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL_OR_EMPTY_NAME.getMessage());
        }
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_CANNOT_EXCEED_MAX_LENGTH.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        CarName carName = (CarName) obj;
        return this.name.equals(carName.getName());
    }
}
