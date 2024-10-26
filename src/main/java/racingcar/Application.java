package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();
        RacingCarService racingCarService = new RacingCarService();

        RacingCarController racingCarController = new RacingCarController(
                racingCarService,
                inputView,
                outputView,
                inputValidator
        );

        racingCarController.run();
    }
}
