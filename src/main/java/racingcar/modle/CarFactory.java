package racingcar.modle;

public class CarFactory {

    public Car createCar(String carName) {
        return new Car(carName);
    }
}
