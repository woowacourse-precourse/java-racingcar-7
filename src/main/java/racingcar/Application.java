package racingcar;

import racingcar.application.RacingService;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.presentation.RacingGameController;

public class Application {
    public static void main(String[] args) {
        MovingStrategy movingStrategy = new RandomMovingStrategy(); // 복잡해진다면 팩토리로 관리한다.
        RacingService racingService = new RacingService(movingStrategy);
        RacingGameController racingGameController = new RacingGameController(racingService);
        racingGameController.run();
    }
}
