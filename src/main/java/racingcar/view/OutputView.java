package racingcar.view;

import java.util.List;
import racingcar.constants.RegexConstants;

public class OutputView {

    public static void printResultMessage() {
        System.out.println(Message.RESULT.message);
    }

    public static void printRoundResult(List<String> roundResult) {
        roundResult.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningCars(List<String> winningCars) {
        System.out.print(Message.WINNER.message);
        System.out.println(String.join(RegexConstants.COMMA_SPACE, winningCars));
    }

    private enum Message {
        RESULT("실행 결과"),
        WINNER("최종 우승자 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
