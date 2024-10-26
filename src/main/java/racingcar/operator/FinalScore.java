package racingcar.operator;

import java.util.ArrayList;
import java.util.List;
import racingcar.user.UserInfo;
import racingcar.view.OutputView;

public class FinalScore {
    List<UserInfo> topScores = new ArrayList<>();
    OutputView output = new OutputView();
    int maxScore = Integer.MIN_VALUE;

    public void totalScore(UserInfo[] users) {

        for (UserInfo user : users) {
            if (user.scoreNum > maxScore) {
                maxScore = user.scoreNum;
            }
        }

        for (UserInfo user : users) {
            if (user.scoreNum == maxScore) {
                topScores.add(user);
            }
        }
        Winner();
    }

    private void Winner() {
        output.PrintWinnerSentence();
        int n = topScores.size();
        for (UserInfo user : topScores) {
            n--;
            output.PrintWinner(user.name);
            if (n != 0) {
                output.PrintRest();
            }
        }
    }
}
