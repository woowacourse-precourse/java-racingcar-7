package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ExceptionMessage;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateEmptyName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY_STRING.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_LIMITATION.getMessage());
        }
    }

    public void tryMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (RacePolicy.canMoveForward(randomNumber)) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
