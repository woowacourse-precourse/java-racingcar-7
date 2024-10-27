package racingcar.model;

import racingcar.validation.Validator;

public class Car {

    private final int RANDOM_MOVE_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        Validator.checkNameLength(name);
        Validator.checkNameNull(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= RANDOM_MOVE_NUMBER) {
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
