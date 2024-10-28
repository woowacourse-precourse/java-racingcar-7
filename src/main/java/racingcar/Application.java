package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new ConsoleInputView();
        RacingCarService racingCarService = new RacingCarService();
        OutputView outputView = new ConsoleOutputView();
        RacingCarController racingCarController = new RacingCarController(inputView, racingCarService, outputView);
        racingCarController.runGame();
    }
}
