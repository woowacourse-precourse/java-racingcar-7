package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private Game game;

    public void run() {
        String[] carNames = InputView.inputCarNames();
        int count = InputView.inputCount();

        game = new Game(carNames);
        game.start();
        play(count);
    }

    private void play(int count) {
        int currentCnt = 0;
        while (currentCnt < count) {
            game.playTurn();
            OutputView.printProgressRacing(game.getCars());
            currentCnt++;
        }
        List<String> winners = game.getWinners();
        OutputView.printWinners(winners);
    }
}
