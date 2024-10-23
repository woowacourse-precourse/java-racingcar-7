package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;
import racingcar.constant.MovementCondition;

public class Car {
    private static final String SPACE = " ";
    private static final int MOVING_CRITERIA = 4;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final String name;

    private Car(final String name) {
        validateNameLength(name.trim());
        validateNoSpaceBetweenName(name.trim());

        this.name = name.trim();
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

    public MovementCondition decideToMove(final int number) {
        if (number >= MOVING_CRITERIA) {
            return MovementCondition.FORWARD;
        }

        return MovementCondition.STOP;
    }

    public String getName() {
        return name;
    }
}
