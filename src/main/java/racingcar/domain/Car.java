package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import racingcar.validation.Validator;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        Validator.checkNameLength(name);
        Validator.checkNameNull(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= RandomNumberGenerator.RANDOM_MOVE_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
