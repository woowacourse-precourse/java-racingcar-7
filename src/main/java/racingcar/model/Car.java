package racingcar.model;

import static racingcar.global.constants.RaceConfigValues.MAX_CAR_NAME_LENGTH_NUMBER;

import racingcar.global.message.ErrorMessage;
import racingcar.global.utils.RaceRandomUtils;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_LONG.getMessage() + ": " + name);
        }
        if (!isValidCarName(name)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INVALID_CHARACTERS.getMessage() + ": " + name);
        }
        this.name = name;
    }

    private boolean isValidCarName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }

    public void move() {
        if (RaceRandomUtils.generateRandomNumber() >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
