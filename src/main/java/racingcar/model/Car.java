package racingcar.model;

import java.util.Objects;

public class Car {

    public static final int START_POSITION = 0;
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
