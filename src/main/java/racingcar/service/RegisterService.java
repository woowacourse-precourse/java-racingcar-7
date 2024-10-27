package racingcar.service;

import racingcar.domain.Cars;

public class RegisterService {
    private final Cars cars;

    public RegisterService(Cars cars) {
        this.cars = cars;
    }

    public void registerCars(String carNames) {
        cars.registerCars(carNames);
    }
}
