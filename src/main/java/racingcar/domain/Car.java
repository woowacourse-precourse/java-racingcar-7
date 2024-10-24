package racingcar.domain;

import static racingcar.util.Constant.MIN_MOVE_VALUE;

public class Car {

    private final String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void move(Integer randomValue) {
        if (randomValue >= MIN_MOVE_VALUE) {
            this.distance += randomValue;
        }
    }
}
