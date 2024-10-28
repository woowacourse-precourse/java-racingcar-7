package racingcar.car;

import racingcar.validateName.ValidateName;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        new ValidateName().validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
