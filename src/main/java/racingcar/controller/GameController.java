package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView;

    public GameController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carRegistrationRequest = inputView.readCarRegistrationRequest();
        List<String> cars = Arrays.asList(carRegistrationRequest.split(","));
        int roundCount = inputView.readRoundCount();
    }
}
