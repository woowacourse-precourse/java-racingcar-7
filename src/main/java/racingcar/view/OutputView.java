package racingcar.view;

import racingcar.model.domain.RoundResult;

import java.util.List;

public class OutputView {
    public static void printResult(List<RoundResult> roundResults) {
        System.out.println("실행 결과");
        for (RoundResult roundResult : roundResults) {
            System.out.print(roundResult);
        }
    }
    public static void printWinner(List<String> winners) {
        System.out.printf("최종 우승자 : %s\n", String.join(", ", winners));
    }
}
