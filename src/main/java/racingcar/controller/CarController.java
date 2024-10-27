package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;

import java.util.List;

public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public List<Car> generateCars(String carNames) {
        return carService.generateCars(carNames);
    }
}
