package racingcar.appConfig;

import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewConfig {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewConfig() {
        this.inputView = new ConsoleInputView();
        this.outputView = new ConsoleOutputView();
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }
}