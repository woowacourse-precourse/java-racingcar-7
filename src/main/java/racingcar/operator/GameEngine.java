package racingcar.operator;

import java.util.ArrayList;
import java.util.List;
import racingcar.user.SettingGameUser;
import racingcar.user.UserObject;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameEngine {
    List<String> winners = new ArrayList<>();
    UserObject[] user = new UserObject[InputView.result.length];
    RandomNumberGenerator random = new RandomNumberGenerator();
    OutputView output = new OutputView();
    WinnerSelector finalScore = new WinnerSelector();

    public void runGame() {
        output.printResultSentence();
        for (int i = 0; i < InputView.trynum; i++) {
            startTurn();
        }
        finalScore.selectWinner(user);
    }

    private void startTurn() {
        for (int i = 0; i < user.length; i++) {
            playUserTurn(user[i]);
        }
        output.printTurnResult();
    }

    private void playUserTurn(UserObject user) {
        int randomNum = random.generateRandomNumber();
        if (randomNum >= 4) {
            updateUserScore(user);
        }
    }

    private void updateUserScore(UserObject user) {
        user.score += "-";
        user.scoreNum++;
    }

    public GameEngine() {
        this.user = SettingGameUser.user;
    }
}
