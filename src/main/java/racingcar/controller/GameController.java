package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;

public class GameController {
    private InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {

        List<String> carNames = new ArrayList<>(inputView.readCarNames());
        System.out.println(carNames);
    }
}

