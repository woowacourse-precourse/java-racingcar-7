package racingcar.controller;

import racingcar.dto.CreateCarsRequest;
import racingcar.service.CarService;
import racingcar.util.Parser;

public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void createCars(CreateCarsRequest request) {
        carService.createCars(Parser.parseDelimitersString(request.carNames()));
    }
}