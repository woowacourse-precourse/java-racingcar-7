package racingcar.car;

import static racingcar.global.util.Validator.ValidateCarName;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
        ValidateCarName(name);
    }

    public void move() {
        position++;
    }

    @Override
    public String toString() {
        return "%s : %s".formatted(name, "-".repeat(position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
