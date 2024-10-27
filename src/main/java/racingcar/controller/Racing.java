package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class Racing {
    private final InputView inputView;
    private final CarService carService;

    public Racing(InputView inputView, CarService carService) {
        this.inputView = inputView;
        this.carService = carService;
    }

    public void ready () {
        String rawCarNames = inputView.getCarNames();

        Cars cars = carService.createCars(rawCarNames);
    }
}
