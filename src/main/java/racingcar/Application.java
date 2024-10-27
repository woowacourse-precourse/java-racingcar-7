package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.util.RandomPicker;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomPicker randomPicker = new RandomPicker();
        MoveStrategy moveStrategy = new RandomMoveStrategy(randomPicker);
        RacingCarService racingCarService = new RacingCarService(moveStrategy);
        RacingCarController racingCarController = new RacingCarController(racingCarService);

        racingCarController.run();

    }
}
