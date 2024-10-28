package racingcar.controller;

import java.util.List;
import racingcar.module.TurnManager;
import racingcar.user.UserObject;
import racingcar.view.OutputView;

public class GameController {

    public void runGame(UserObject[] user) {
        OutputView.printResultSentence();
        TurnManager turnManager = new TurnManager(user);
        turnManager.progressTurn();
    }

    public static void displayProgress(UserObject[] user) {
        for (int i = 0; i < user.length; i++) {
            String name = user[i].getUserName();
            String score = user[i].getUserScoreString();
            OutputView.printTurnResult(name, score);
        }
        OutputView.printEmpty();
    }

    public static void displayWinner(List<String> topScoreList) {
        OutputView.printWinnerSentence();
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
