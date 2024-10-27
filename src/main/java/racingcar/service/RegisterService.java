package racingcar.service;

import racingcar.domain.Cars;

public class RegisterService {
    public Cars registerCars(String carNames) {
        Cars cars = new Cars();
        cars.registerCars(carNames);
        return cars;
    }
}
