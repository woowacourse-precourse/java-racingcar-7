package racingcar.domain;

import racingcar.validate.CarNameValidation;

public class Car {
    private final String name;
    private int position;

    Car(String name) {
        CarNameValidation.validateName(name);
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getFinalPosition(int position) {
        return "-".repeat(position);
    }

    public void increasePosition(int randomMovement) {
        position++;
    }

    public String getName() {
        return name;
    }

}
