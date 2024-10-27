package racingcar.view;

import racingcar.view.enums.ViewMessages;

public class OutputView {

    public static void attemptsResult() {
        System.out.println();
        System.out.println(ViewMessages.ATTEMPTS_RESULT.getViewMessages());
    }

    public static void eachAttemptsResult(String gameRoundHistory) {
        System.out.print(gameRoundHistory);
    }

    public static void finalWinners() {
        System.out.print(ViewMessages.FINAL_WINNERS.getViewMessages());
    }

    public static void finalWinnersResult(String gameRoundHistory) {
        System.out.print(gameRoundHistory);
    }

}
