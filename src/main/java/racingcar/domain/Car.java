package racingcar.domain;

import racingcar.util.InputValidator;

public class Car {
    private String name;
    private String movement;

    public Car(String name, String movement) {
        InputValidator.validCarName(name);
        this.name = name;
        this.movement = movement;
    }

    public String getMovement() {
        return movement;
    }

    public void updateMovement(String m) {
        this.movement += m;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + movement;
    }
}
