package racingcar.domain.dto;

import racingcar.domain.Car;

public class CarSnapShot {

    private final String name;
    private final int position;

    public CarSnapShot(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
