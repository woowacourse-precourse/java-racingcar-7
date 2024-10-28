package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGame {
    public void run() {
        String[] carNames = InputView.getCarNames();
        int moveCount = InputView.getMovementCount();

        RacingGame game = new RacingGame(carNames);

        for (int i = 0; i < moveCount; i++) {
            game.moveCar();
            OutputView.printCarPosition(game.getCars());
        }

        String winners = game.getWinners();
        OutputView.printWinner(winners);
    }
}
