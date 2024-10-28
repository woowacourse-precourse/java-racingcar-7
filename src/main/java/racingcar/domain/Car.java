package racingcar.domain;

import racingcar.move.MoveGenerator;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move(MoveGenerator moveGenerator) {
        if (moveGenerator.move()) {
            location += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
