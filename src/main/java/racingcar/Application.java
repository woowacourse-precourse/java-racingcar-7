package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import service.PlayerService;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new InputView(), new OutputView(),
                new PlayerService());
        
        racingGameController.run();
    }
}
