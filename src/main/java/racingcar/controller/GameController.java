package racingcar.controller;

import racingcar.operator.GameEngine;
import racingcar.user.SettingGameUser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void runGame() {
        new SettingGameUser();
        OutputView.printResultSentence();
        GameEngine gameEngine = new GameEngine();
        for (int i = 0; i < InputView.trynum; i++) {
            gameEngine.progressGame();
        }
    }

    public static void displayProgress() {
        OutputView.printTurnResult();
    }

    public static void displayWinner() {

    }
}
