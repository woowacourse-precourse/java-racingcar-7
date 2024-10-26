package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;

public class CarController {
    private final CarService carService;

    public CarController(final CarService carService) {
        this.carService = carService;
    }

    public List<String> getCarNames(final String carNames) {
        return carService.splitCarNames(carNames);
    }


    public List<Car> registerCar(final List<String> carNames) {
        return carService.registerCar(carNames);
    }
}
