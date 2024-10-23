package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private final InputView inputView;
    private final OutputView outputView;

    public Race(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {

    }
}
