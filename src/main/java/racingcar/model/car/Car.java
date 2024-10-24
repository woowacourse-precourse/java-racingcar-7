package racingcar.model.car;

import racingcar.common.ErrorMessage;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final Position position;

    public Car(final String name) {
        validateNameLength(name);
        this.name = name;
        this.position = new Position();
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
