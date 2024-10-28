package racingcar.view;

import racingcar.model.domain.GameResult;
import racingcar.model.domain.RoundResult;

import java.util.List;

public class OutputView {
    public static void printResult(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            System.out.print(roundResult + "\n");
        }
    }
    public static void printWinner(List<String> winners) {
        System.out.printf("최종 우승자 : %s\n", String.join(", ", winners));
    }
    public static void printError(String message) {
        System.out.println(message + "\n입력 오류로 프로그램을 종료합니다.");
    }
}
