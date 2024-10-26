package racingcar.operator;

import java.util.ArrayList;
import java.util.List;
import racingcar.user.UserObject;
import racingcar.view.OutputView;

public class WinnerSelector {
    List<UserObject> topScores = new ArrayList<>();
    OutputView output = new OutputView();
    int maxScore = Integer.MIN_VALUE;

    public void selectWinner(UserObject[] users) {

        for (UserObject user : users) {
            if (user.scoreNum > maxScore) {
                maxScore = user.scoreNum;
            }
        }

        for (UserObject user : users) {
            if (user.scoreNum == maxScore) {
                topScores.add(user);
            }
        }
        extractWinner();
    }

    private void extractWinner() {
        output.printWinnerSentence();
        int n = topScores.size();
        for (UserObject user : topScores) {
            n--;
            output.printWinner(user.name);
            if (n != 0) {
                output.printWinner(user.name);
                break;
            }
            output.printRest();
        }
    }
}
