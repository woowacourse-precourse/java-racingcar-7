package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.message.ErrorMessage;

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
        int randomNumber = Randoms.pickNumberInRange(0, 9);
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
