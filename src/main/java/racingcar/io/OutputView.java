package racingcar.io;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String SCORE_MARK = "-";
    private static final String FINAL_OUTPUT_DELIMITER = ", ";

    public void printCurResult(Map<String,Integer> playerScoreBoard) {
        playerScoreBoard.forEach((player,score)->{
            System.out.println(player+" : "+SCORE_MARK.repeat(score));
        });
        System.out.println();
    }

    public void printFinalResult(Map<String,Integer> playerScoreBoard) {
        Set<String> winners=new HashSet<>();
        int maxScore=0;
        for (Map.Entry<String,Integer> playerentry: playerScoreBoard.entrySet()) {
            String player = playerentry.getKey();
            int score = playerentry.getValue();

            if (score > maxScore) {
                winners.clear();
                winners.add(player);
                maxScore = score;
            }
            if (score == maxScore) {
                winners.add(player);
            }
        }

        System.out.println("최종 우승자 : "+String.join(FINAL_OUTPUT_DELIMITER,winners));
    }
}
