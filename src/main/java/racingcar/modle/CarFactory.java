package racingcar.modle;

public class CarFactory {

    public Car create(String carName) {
        return new Car(carName);
    }
}
