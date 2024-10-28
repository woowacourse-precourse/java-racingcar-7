package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.getRacingCarsAndTryNumber()[0];
        String tryNumber= InputView.getRacingCarsAndTryNumber()[1];
        RacingGameService racingGameService = new RacingGameService();
        RacingGameController racinggameController = new RacingGameController(racingGameService);
        racinggameController.startRace(carNames,tryNumber);
    }
}
