package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.InputView;

public class GameController {
    public static void start() {
        String carNames = InputView.carName();
        int gameCount = InputView.gameCount();

        RacingCar racingCar = new RacingCar(carNames, gameCount);

    }
}
