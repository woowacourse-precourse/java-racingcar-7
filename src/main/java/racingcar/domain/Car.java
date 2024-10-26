package racingcar.domain;

import racingcar.exception.InputValidator;

public class Car {
    private static final int FIRST_POSITION = 0;
    private static final String POSITION_INDICATOR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        InputValidator inputValidator = InputValidator.getInstance();
        inputValidator.validateInvalidCarName(name);

        this.name = name;
        this.position = FIRST_POSITION;
    }

    public void moveForward(boolean isCarMovable) {
        if (isCarMovable) {
            position++;
        }
    }

    public String getCurrentStatus() {
        return String.format("%s : %s\n", name, convertDigitPositionToVisualizedPosition());
    }

    private String convertDigitPositionToVisualizedPosition() {
        return POSITION_INDICATOR.repeat(position);
    }
}
