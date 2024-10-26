package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.ErrorMessage.NOT_ALLOWED_CAR_NAME_LENGTH;

public class Car {
    private static final int INITIAL_POSITION_VALUE = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_RANGE = 1;
    private static final int MAX_RANDOM_RANGE = 9;
    private static final int MIN_VALID_NUMBER = 4;
    private static final String POSITION_STRING_VALUE = "-";

    private final String name;
    private int position;

    public Car(final String name) {
        validate(name);
        this.name = name;
        this.position = INITIAL_POSITION_VALUE;
    }

    public void tryForward() {
        if (canMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public String positionToString() {
        return POSITION_STRING_VALUE.repeat(position);
    }

    private void validate(final String name) {
        validateLength(name);
    }

    private void validateLength(final String name) {
        if (MAX_CAR_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NOT_ALLOWED_CAR_NAME_LENGTH);
        }
    }

    private boolean canMove() {
        return MIN_VALID_NUMBER <= pickRandomNumber();
    }

    int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
    }
}