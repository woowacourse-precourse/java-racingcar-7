package racingcar.domain;

import java.util.List;
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
        final List<Car> cars = inputView.readCarNames();
    }
}
