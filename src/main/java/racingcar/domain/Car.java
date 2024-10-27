package racingcar.domain;

import static racingcar.Application.MOVE_NUM;

public class Car {

    private String name;
    private int Location;

    public Car(String name, int Location) {
        this.name = name;
        this.Location = Location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return Location;
    }

    public void move() {
        Location++;
    }
}
