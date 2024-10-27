package racingcar.model;

import racingcar.view.InputView;

public class Car {
    private String name;
    private String distance;

    public Car(String carName) {
        this.name = carName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

}
