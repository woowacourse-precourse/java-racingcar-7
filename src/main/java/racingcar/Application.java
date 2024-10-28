package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

import java.util.zip.InflaterInputStream;

public class Application {
    public static void main(String[] args) {
        String[] inputs = InputView.getRacingCarsAndTryNumber();
        String carNames = inputs[0];
        String tryNumber= inputs[1];
        RacingGameService racingGameService = new RacingGameService();
        RacingGameController racinggameController = new RacingGameController(racingGameService);
        racinggameController.startRace(carNames,tryNumber);
    }
}
