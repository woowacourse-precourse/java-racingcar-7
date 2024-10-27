package racingcar.model.car;

import java.util.List;

public class CarFactory {
    public static Car createCar(String carName){
        return new Car(carName);
    }

    public static List<Car> createCars(List<String> carNames){
        return carNames.stream().map(CarFactory::createCar).toList();
    }
}
