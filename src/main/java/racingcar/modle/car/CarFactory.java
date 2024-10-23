package racingcar.modle.car;

public class CarFactory {

    public Car create(String carName) {
        return new Car(carName);
    }
}
