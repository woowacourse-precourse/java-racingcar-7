package racingcar.view;

import java.util.List;
import racingcar.constants.RegexConstants;

public class OutputView {

    public static void printResultMessage() {
        Message.RESULT.display(System.lineSeparator());
    }

    public static void printRoundResult(List<String> roundResult) {
        roundResult.forEach(System.out::println);
        System.out.print(System.lineSeparator());
    }

    public static void printWinningCars(List<String> winningCars) {
        Message.WINNER.display();
        System.out.print(String.join(RegexConstants.COMMA_SPACE, winningCars));
    }

    private enum Message {
        RESULT("실행 결과"),
        WINNER("최종 우승자 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        private void display(String lineSeparator) {
            System.out.print(message + lineSeparator);
        }

        private void display() {
            System.out.print(message);
        }
    }
}
