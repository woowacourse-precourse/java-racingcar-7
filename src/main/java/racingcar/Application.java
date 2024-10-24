package racingcar;

import racingcar.application.RacingService;
import racingcar.domain.RandomMovingStrategy;
import racingcar.presentation.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingService racingService = new RacingService(new RandomMovingStrategy());
        RacingGameController racingGameController = new RacingGameController(racingService);
        racingGameController.run();
    }
}
