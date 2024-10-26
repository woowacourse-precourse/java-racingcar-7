package racingcar.config;

import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.service.impl.RaceServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.impl.ConsoleInputView;
import racingcar.view.impl.ConsoleOutputView;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private final InputController inputController;
    private final RaceController raceController;
    private final RaceService raceService;
    private final OutputView outputView;
    private final InputView inputView;

    private AppConfig() {
        this.inputView = ConsoleInputView.getInstance();
        this.outputView = ConsoleOutputView.getInstance();
        this.raceService = RaceServiceImpl.getInstance();
        this.inputController = InputController.getInstance(this.getInputView());
        this.raceController = RaceController.getInstance(this.getRaceService(), this.getOutputView());
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public InputController getInputController() {
        return inputController;
    }

    public RaceController getRaceController() {
        return raceController;
    }

    public RaceService getRaceService() {
        return raceService;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public InputView getInputView() {
        return inputView;
    }
}
