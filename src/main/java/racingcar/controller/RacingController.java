package racingcar.controller;

import racingcar.dto.RacingRequestDto;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        RacingRequestDto racingRequest = inputView.getRacingRequest();
    }
}
