package racingcar;

import racingcar.domain.MovingStrategy;
import racingcar.domain.RandomMovingStrategy;
import racingcar.presentation.RacingGameController;

public class Application {
    public static void main(String[] args) {
        MovingStrategy movingStrategy = new RandomMovingStrategy(); // 복잡해진다면 팩토리로 관리한다.
        RacingGameController racingGameController = new RacingGameController(movingStrategy);
        racingGameController.run();
    }
}
