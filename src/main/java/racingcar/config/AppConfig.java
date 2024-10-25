package racingcar.config;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public GameController gameController() {
        return new GameController(
                new GameService(),
                new InputView(),
                new OutputView()
        );
    }
}
