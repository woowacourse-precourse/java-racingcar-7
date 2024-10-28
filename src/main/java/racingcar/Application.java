package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.GameRunner;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarService racingCarService = new RacingCarService();
        GameRunner gameRunner = new GameRunner();

        RacingCarController racingCarController= new RacingCarController(inputView, outputView, racingCarService, gameRunner);
        racingCarController.initializeGame();
    }
}
