package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;

public class CarRacingGame {
    public void run() {
        String[] carNames = InputView.getCarNames();
        int moveCount = InputView.getMovementCount();

        RacingGame game = new RacingGame(carNames);

        for (int i = 0; i < moveCount; i++) {
            game.moveCar();
        }
    }
}
