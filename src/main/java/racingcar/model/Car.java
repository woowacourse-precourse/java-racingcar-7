package racingcar.model;

import racingcar.view.InputView;

public class Car {
    private String name;
    private Integer distance = 0;

    public Car(String carName) {
        this.name = carName;
    }

    public void setDistance() {
        this.distance++;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
