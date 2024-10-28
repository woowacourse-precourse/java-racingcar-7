package racingcar.view;

import java.util.List;
import java.util.Map;

public class RacingOutputView {
    public void printResultString() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(Map<String, Integer> carPositions) {
        StringBuilder roundResult = new StringBuilder();
        carPositions.forEach((name, position) -> {
            roundResult.append(name)
                .append(" : ")
                .append("-".repeat(position))
                .append("\n");
        });
        System.out.print(roundResult);
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
