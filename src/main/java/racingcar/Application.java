package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.GameRunner;
import racingcar.service.GameSetup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameSetup racingCarService = new GameSetup();
        GameRunner gameRunner = new GameRunner();

        RacingCarController racingCarController= new RacingCarController(inputView, outputView, racingCarService, gameRunner);
        racingCarController.initializeGame();
    }
}
