package racingcar.service;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RegisterService {
    private final Cars cars;

    public RegisterService(Cars cars) {
        this.cars = cars;
    }

    public void registerCars() {
        String carNames = InputView.carNames();
        cars.registerCars(carNames);
    }
}
