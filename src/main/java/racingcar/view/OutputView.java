package racingcar.view;

import racingcar.view.enums.ViewMessages;

public class OutputView {

    public void attemptsResult() {
        System.out.println();
        System.out.println(ViewMessages.ATTEMPTS_RESULT.getViewMessages());
    }

    public void eachAttemptsResult(String gameRoundHistory) {
        System.out.print(gameRoundHistory);
    }

    public void finalWinners() {
        System.out.print(ViewMessages.FINAL_WINNERS.getViewMessages());
    }

    public void finalWinnersResult(String gameRoundHistory) {
        System.out.print(gameRoundHistory);
    }

}
