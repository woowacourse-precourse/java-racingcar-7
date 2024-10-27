package racingcar.config;

import racingcar.FrontController;
import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.input.InputView;
import racingcar.view.output.ConsoleOutputView;
import racingcar.view.output.OutputView;

public class Config {
    public FrontController frontController() {
        return new FrontController(racingController(), inputView(), outputView());
    }

    private RacingController racingController() {
        return new RacingController(racingService());
    }

    private OutputView outputView() {
        return new ConsoleOutputView();
    }

    private InputView inputView() {
        return new ConsoleInputView();
    }

    private RacingService racingService() {
        return new RacingServiceImpl();
    }
}
