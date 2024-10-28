package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final RacingService racingService = new RacingService(inputView, outputView);
        final RacingController racingController = new RacingController(racingService);

        racingController.play();
    }
}