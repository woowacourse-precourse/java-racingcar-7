package racingcar.service;

import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;

public class CarService {

    public Cars createCars(CarNames carNames) {
        return Cars.from(carNames);
    }
}