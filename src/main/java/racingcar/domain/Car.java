package racingcar.domain;

import static racingcar.constant.DomainConstants.MOVE_THRESHOLD;
import static racingcar.constant.ErrorMessages.NAME_LENGTH_ERROR_MESSAGE;

public class Car {
    private int position = 0;
    private String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            this.position += 1;
        }
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
