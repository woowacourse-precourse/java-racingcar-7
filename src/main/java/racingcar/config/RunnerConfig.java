package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RunnerConfig {
    private static final RunnerConfig INSTANCE = new RunnerConfig();

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingController racingController;

    private RunnerConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingController = new RacingController(inputView, outputView);
    }

    public static RunnerConfig getInstance() {
        return INSTANCE;
    }

    public void run() {
        racingController.playGame();
    }
}
