package racingcar.controller;

import racingcar.service.CarRaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {

    private final CarRaceService carsService = new CarRaceService();

    public void race(String carNames, String gameMatches) {
        carsService.init(carNames, gameMatches);
        carsService.playGame();
    }

}
