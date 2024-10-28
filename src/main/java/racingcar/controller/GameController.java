package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    public static void start() {
        String carNames = InputView.carName();
        int gameCount = InputView.gameCount();

        RacingCar racingCar = new RacingCar(carNames);

        OutputView.title();
        for (int i = 0; i < gameCount; i++) {
            int[] results = racingCar.racing();
            OutputView.printProcess(racingCar.getCarNameList(), results);
        }

        List<String> winners = racingCar.getWinners();
        OutputView.printWinners(winners);

    }
}
