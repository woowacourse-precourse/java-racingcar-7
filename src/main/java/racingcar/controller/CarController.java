package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.validate.CarValidator;

public class CarController {
    private final CarService carService;
    private final CarValidator carValidator;

    public CarController(final CarService carService, final CarValidator carValidator) {
        this.carService = carService;
        this.carValidator = carValidator;
    }

    public List<String> getCarNames(final String carNames) {
        ArrayList<String> splitCarNames = carService.splitCarNames(carNames);

        splitCarNames.forEach(carValidator::carNameLengthLimit5);
        carValidator.noDuplicateCarNames(splitCarNames);

        return splitCarNames;
    }


    public List<Car> registerCar(final List<String> carNames) {
        return carService.registerCar(carNames);
    }
}
