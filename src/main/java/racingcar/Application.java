package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private static final RacingService RACING_SERVICE = new RacingService();
    private static final Validator validator = Validator.getInstance();

    public static void main(String[] args) {
        RacingController racingController = new RacingController(inputView, outputView, RACING_SERVICE, validator);
        racingController.start();
    }
}
