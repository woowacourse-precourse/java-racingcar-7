package racingcar.domain.race;

import racingcar.domain.car.Car;

public class CarRecord {

    private String carName;
    private int distance;

    private CarRecord(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public static CarRecord of(Car car) {
        return new CarRecord(car.getCarName(), car.getDistance());
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
