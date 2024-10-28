package racingcar.domain;

import static racingcar.constant.ExecptionMessage.CAR_NAME_CONTAIN_EMPTY_MESSAGE;
import static racingcar.constant.ExecptionMessage.CAR_NAME_LENGTH_MESSAGE;
import static racingcar.constant.ExecptionMessage.CAR_NAME_NULL_OR_EMPTY_MESSAGE;

import racingcar.exception.CarNameContainEmptyException;
import racingcar.exception.CarNameLengthExeption;
import racingcar.exception.CarNameNullExeption;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
        validateContainEmpty(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new CarNameNullExeption(CAR_NAME_NULL_OR_EMPTY_MESSAGE.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameLengthExeption(CAR_NAME_LENGTH_MESSAGE.getMessage());
        }
    }

    private void validateContainEmpty(String name) {
        if (name.contains(" ")) {
            throw new CarNameContainEmptyException(CAR_NAME_CONTAIN_EMPTY_MESSAGE.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int moveNumber) {
        if (moveNumber >= 4) {
            position++;
        }
    }
}
