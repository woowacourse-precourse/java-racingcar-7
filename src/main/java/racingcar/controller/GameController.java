package racingcar.controller;

import java.io.IOException;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView = new InputView();

    public void startGame() throws IOException {
        String carsName = inputView.getCarNames();
    }

    private void playGame() {

    }
}
