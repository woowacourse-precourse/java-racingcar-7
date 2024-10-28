package racingcar.model;

import racingcar.enums.ExceptionMessages;
import racingcar.exception.CarNameException;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String COMMA = ",";
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void validateCarName(String name) {
        validateEmptyName(name);
        validateNameLength(name);
        validateComma(name);
    }

    private void validateEmptyName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new CarNameException(ExceptionMessages.EMPTY_INPUT.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameException(ExceptionMessages.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private void validateComma(String name) {
        if (name.contains(COMMA)) {
            throw new CarNameException(ExceptionMessages.INVALID_COMMA_INPUT.getMessage());
        }
    }
}
