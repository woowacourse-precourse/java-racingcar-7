package output;

import java.util.Map;

public class ScoreOutput {
    public void printNoticeOfExecution() {
        System.out.println("\n실행 결과");
    }

    public void printCurrentScore(Map<String, String> currentScore) {
        for (Map.Entry<String, String> entry : currentScore.entrySet()) {
            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
