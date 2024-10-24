package racingcar.modle.vehicle.car;

public class CarFactory {

    public Car create(String carName) {
        return new Car(carName);
    }
}
