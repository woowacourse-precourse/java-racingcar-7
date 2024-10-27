package custom.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void displayRaceResultPrompt() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void displayRaceResultsByRound(Map<String, Integer> allScores) {
        for (Map.Entry<String, Integer> entry : allScores.entrySet()) {
            String carName = entry.getKey();
            int score = entry.getValue();

            System.out.println(carName + " : " + "-".repeat(score));
        }
        System.out.println();
    }

    public void displayRaceWinners(List<String> winners) {
        String winnerList = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerList);
    }

    public void displayError(String message) {
        System.out.println(message);
    }
}
