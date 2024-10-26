package racingcar.car;

public class CarSimpleFactory {

    public static Car createCar(String name) {
        return new Car(name);
    }
}
