package racingcar.controller;

import java.util.HashMap;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final CarService carService;

    public RacingController(InputView inputView, CarService carService) {
        this.inputView = inputView;
        this.carService = carService;
    }

    public void startRacing() {
        String carNames = inputView.inputCarNames();

        HashMap<String, Integer> cars = carService.splitCarNames(carNames);
    }
}
