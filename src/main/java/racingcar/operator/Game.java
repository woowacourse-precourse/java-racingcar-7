package racingcar.operator;

import java.util.ArrayList;
import java.util.List;
import racingcar.user.SettingGameUser;
import racingcar.user.UserInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    List<String> winners = new ArrayList<>();
    UserInfo[] user = new UserInfo[InputView.result.length];
    Random random = new Random();
    OutputView output = new OutputView();
    FinalScore finalScore = new FinalScore();

    public void GameProgress() {
        output.PrintResultSentence();
        for (int i = 0; i < InputView.trynum; i++) {
            StartTurn();
        }
        finalScore.totalScore(user);
    }

    private void StartTurn() {
        for (int i = 0; i < user.length; i++) {
            Operator(user[i]);
        }
        output.ShowResult();
    }


    private void Operator(UserInfo user) {
        int randomNum = random.ExtractRandomNum();
        if (randomNum >= 4) {
            Drive(user);
        }
    }

    private void Drive(UserInfo user) {
        user.score += "-";
        user.scoreNum++;
    }

    public Game() {
        this.user = SettingGameUser.user;
    }
}
