package racingcar;

import java.util.List;

public class RacingOutputView {
    public void printResultString() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
