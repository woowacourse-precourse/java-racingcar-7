package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingService racingService = new RacingService();
        RacingController racingController = new RacingController(inputView, outputView, racingService);

        racingController.run();
    }
}
