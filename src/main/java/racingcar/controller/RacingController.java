package racingcar.controller;

import racingcar.model.Racing;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        // Todo : record를 이용하여 DTO 로 넘겨주는 방식으로 리팩토링 가능할듯함.
        String carNames = readCarNames();
        int tryCount = readTryCount();

        Racing racing = new Racing(tryCount, carNames);
        racing.startRacing();
    }

    private String readCarNames() {
        return inputView.readCarNames();
    }

    private int readTryCount() {
        return inputView.readTryCount();
    }
}
