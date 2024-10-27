package racingcar.controller;

import java.util.List;
import racingcar.operator.GameEngine;
import racingcar.operator.WinnerSelector;
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
        displayWinner();
    }

    public static void displayProgress() {
        OutputView.printTurnResult();
    }

    public static void displayWinner() {
        OutputView.printWinnerSentence();
        List<String> topScoreList = new WinnerSelector().getTopScores();
        for (int i = 0; i < topScoreList.size(); i++) {
            displayRest(i);
            OutputView.printWinner(topScoreList.get(i));
        }
    }

    public static void displayRest(int index) {
        if (index != 0) {
            OutputView.printRest();
        }
    }
}
