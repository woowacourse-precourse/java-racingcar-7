package racingcar.model.result;

import racingcar.model.car.Car;

public class CarRecord {
    private final String carName;
    private final int movedDistance;

    public CarRecord(String carName, int movedDistance) {
        this.carName = carName;
        this.movedDistance = movedDistance;
    }


    public String getCarName() {
        return carName;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    public static CarRecord from(Car car) {
        return new CarRecord(car.getName(), car.getMovedDistance());
    }
}
