package output;

import java.util.Map;

public class ScoreOutput {
    public void printResultOfExecution() {
        System.out.println("\n실행 결과");
    }

    // 입력된 자동차 이름 순서대로 출력되지 않는다.
    public void printCurrentScore(Map<String, String> currentScore) {
        for (Map.Entry<String, String> entry : currentScore.entrySet()) {
            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
