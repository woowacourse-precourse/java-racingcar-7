package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static Car createCar(String name) {
        return new Car(name);
    }

    public static List<Car> createCarList(List<String> carNames) {
        return carNames.stream().map(CarFactory::createCar).collect(Collectors.toList());
    }
}
