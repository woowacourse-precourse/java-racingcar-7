package racingcar.view;

import java.util.ArrayList;
import racingcar.constant.Constant;
import racingcar.model.RoundRecord;

public class OutputView {
    private ArrayList<RoundRecord> gameResult = new ArrayList<>();
    private ArrayList<String> gameWinner = new ArrayList<>();

    public void setGameResult(ArrayList<RoundRecord> result) {
        gameResult = result;
    }

    public void setGameWinner(ArrayList<String> winner) {
        gameWinner = winner;
    }

    public void printGameResult() {
        System.out.println(Constant.OUTPUT_PROMPT);

        for (RoundRecord roundResult : gameResult) {
            roundResult.getRoundResult();
            System.out.println();
        }

        System.out.print(Constant.WINNER_PROMPT);
        System.out.print(String.join(Constant.JOIN_DELIMITER, gameWinner));
    }
}
