package racingcar.view;

import racingcar.model.domain.GameResult;
import racingcar.model.domain.RoundResult;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printInputName() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    public static void printInputCount() {
        System.out.print("시도할 횟수는 몇 회인가요?\n");
    }

    public static void printResult(GameResult gameResult) {
        System.out.print("\n실행결과\n");
        printRecord(gameResult.getRoundResults());
        printWinner(gameResult.getWinners());
    }

    private static void printRecord(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            System.out.print(roundResult + "\n");
        }
    }

    private static void printWinner(List<String> winners) {
        System.out.printf("최종 우승자 : %s\n", String.join(", ", winners));
    }
}
