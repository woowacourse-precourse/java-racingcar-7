package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarService racingCarService = new RacingCarService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarController racingCarController = new RacingCarController(racingCarService, inputView, outputView);

        racingCarController.startGame();
    }
}
