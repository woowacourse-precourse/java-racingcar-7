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

    public void moveForward() {
        position++;
    }
}
