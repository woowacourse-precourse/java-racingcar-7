package racingcar.factory;

import racingcar.model.CarNames;
import racingcar.model.Cars;

public class CarsFactory {
    public static Cars createCars(CarNames carNames) {
        Cars cars = new Cars();
        carNames.getNames().stream()
                .map(CarFactory::createCar)
                .forEach(cars::addCar);
        return cars;
    }
}
