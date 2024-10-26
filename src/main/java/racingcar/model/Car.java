package racingcar.model;

import racingcar.util.CarNameValidator;

public class Car {

    private int position;
    private final String name;
    private static final int MIN_FORWARD_REQUIREMENT = 4;

    public Car(String name) {
        CarNameValidator.checkOverRange(name);
        CarNameValidator.checkSpace(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void carMove(int number) {
        if (number >= MIN_FORWARD_REQUIREMENT) {
            position++;
        }
    }
}
