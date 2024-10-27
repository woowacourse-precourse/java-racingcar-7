package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.model.RandomDriveStrategy;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        CarRacingController carRacingGame = new CarRacingController(
                new InputView(),
                new OutputView(),
                new RandomDriveStrategy(new RandomNumberGenerator())
        );

        carRacingGame.run();
    }
}
