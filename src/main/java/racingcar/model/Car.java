package racingcar.model;

import racingcar.constant.AppConstants;
import racingcar.constant.ErrorMessage;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= AppConstants.MOVE_THRESHOLD) {
            position++;
        }
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > AppConstants.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }
    }
}