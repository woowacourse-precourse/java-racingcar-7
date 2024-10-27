package racingcar.controller;

import java.util.List;
import racingcar.operator.GameEngine;
import racingcar.operator.WinnerSelector;
import racingcar.user.UserObject;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private UserObject[] user;
    private int NUMBER_OF_USERS;
    GameEngine gameEngine = new GameEngine();

    public void runGame() {
        OutputView.printResultSentence();
        progressGame();
        displayWinner();
    }

    private void progressGame() {
        for (int i = 0; i < InputView.trynum; i++) {
            startTurn();
        }
    }

    private void startTurn() {
        for (int i = 0; i < user.length; i++) {
            gameEngine.extractRandom();
            gameEngine.scoreUpdate(user[i]);
        }
        displayProgress();
    }

    private void displayProgress() {
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            String name = user[i].getUserName();
            String score = user[i].getUserScoreString();
            OutputView.printTurnResult(name, score);
        }
        OutputView.printEmpty();
    }

    private void displayWinner() {
        OutputView.printWinnerSentence();
        List<String> topScoreList = new WinnerSelector(user).getTopScores();
        for (int i = 0; i < topScoreList.size(); i++) {
            displayRest(i);
            OutputView.printWinner(topScoreList.get(i));
        }
    }

    private void displayRest(int index) {
        if (index != 0) {
            OutputView.printRest();
        }
    }

    public GameController(UserObject[] user) {
        this.user = user;
        NUMBER_OF_USERS = user.length;
    }

}
