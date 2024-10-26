package racingcar.view;

import java.util.ArrayList;
import racingcar.constant.Constant;
import racingcar.model.RoundRecord;

public class OutputView {

    private ArrayList<RoundRecord> gameResult = new ArrayList<>();
    private ArrayList<String> gameWinner = new ArrayList<>();
    private int gameRound;
    private String winnerResult = "";

    public void setGameResult(ArrayList<RoundRecord> result) {
        gameResult = result;
    }

    public void setGameRound(int round) {
        gameRound = round;
    }

    public void setGameWinner(ArrayList<String> winner) {
        gameWinner = winner;
    }

    public void printGameResult() {
        System.out.println(Constant.OUTPUT_PROMPT);

        for(int i=0; i<gameRound; i++) {
            gameResult.get(i).getRoundResult();
            System.out.println();;
        }

        System.out.print(Constant.WINNER_PROMPT);

        for(int i=0; i<gameWinner.size(); i++) {
            winnerResult += gameWinner.get(i);
        }

        System.out.println(winnerResult);

    }
}
