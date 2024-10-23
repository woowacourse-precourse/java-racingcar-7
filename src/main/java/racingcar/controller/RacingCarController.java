package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarMakerService;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final CarMakerService carMakerService;

    public RacingCarController(InputView inputView,
                               CarMakerService carMakerService) {
        this.inputView = inputView;
        this.carMakerService = carMakerService;
    }

    public void startGame() {
        String carNames = inputView.scanCarNames();
        int tryCount = inputView.scanTryCount();
        playGame(carNames, tryCount);
    }

    public void playGame(String carNames, int tryCount) {
        List<Car> cars = carMakerService.makeCars(carNames);
    }
}
