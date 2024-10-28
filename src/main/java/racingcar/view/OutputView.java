package racingcar.view;

import racingcar.model.domain.GameResult;
import racingcar.model.domain.RoundResult;

import java.util.List;

public class OutputView {
    public static void printRecord(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            System.out.print(roundResult + "\n");
        }
    }
    public static void printWinner(List<String> winners) {
        System.out.printf("최종 우승자 : %s\n", String.join(", ", winners));
    }
}
