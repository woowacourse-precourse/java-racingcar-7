package racingcar.model;

import racingcar.global.message.ErrorMessage;
import racingcar.global.utils.RaceRandomUtils;


public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_LONG.getMessage() + ": " + name);
        }
        if (!name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INVALID_CHARACTERS.getMessage() + ": " + name);
        }
        this.name = name;
    }

    public void move() {
        int randomNumber = RaceRandomUtils.generateRandomNumber();
        if (randomNumber >= 4) {
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
