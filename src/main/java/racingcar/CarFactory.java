package racingcar;

public class CarFactory {
    public Car createCar(String name) {
        return new Car(name);
    }
}
