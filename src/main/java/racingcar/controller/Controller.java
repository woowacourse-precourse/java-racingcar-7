package racingcar.controller;

import java.util.List;
import racingcar.service.Service;
import racingcar.view.InputView;

public class Controller {
    private final InputView inputView;
    private final Service service;

    public Controller(final InputView inputView, final Service service) {
        this.inputView = inputView;
        this.service = service;
    }

    public String inputCarNames() {
        return inputView.getCarNames();
    }

    public int inputAttemptCount() {
        return inputView.getAttemptCount();
    }

    public List<String> getCarNames(final String carNames) {
        return service.splitCarNames(carNames);
    }
}
