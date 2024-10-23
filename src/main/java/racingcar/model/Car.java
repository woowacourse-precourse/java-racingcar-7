package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;

public class Car {
    private static final String SPACE = " ";
    private static final int MOVEMENT_BASE = 0;
    private static final int MOVE_FORWARD_AMOUNT = 1;
    private static final int MOVING_CRITERIA = 4;
    private static final int MOVING_CRITERIA_FROM = 0;
    private static final int MOVING_CRITERIA_TO = 9;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final String name;
    private int movement;

    private Car(final String name) {
        validateNameLength(name.trim());
        validateNoSpaceBetweenName(name.trim());

        this.name = name.trim();
        this.movement = MOVEMENT_BASE;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    private void validateNameLength(final String name) {
        if (name.isBlank() || name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getMessage());
        }
    }

    private void validateNoSpaceBetweenName(final String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_SPACE.getMessage());
        }
    }

    private boolean decideToMove() {
        return Randoms.pickNumberInRange(MOVING_CRITERIA_FROM, MOVING_CRITERIA_TO) >= MOVING_CRITERIA;
    }

    public void moveForward() {
        if (decideToMove()) {
            movement += MOVE_FORWARD_AMOUNT;
        }
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
