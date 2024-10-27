package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.GameRunner;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarService racingCarService = new RacingCarService();
        GameRunner gameRunner = new GameRunner();

        RacingCarController racingCarController= new RacingCarController(inputView, racingCarService, gameRunner);
        racingCarController.initializeGame();

    }
}
