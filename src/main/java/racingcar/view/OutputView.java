package racingcar.view;

import racingcar.enums.ViewMessage;

public class OutputView {

    public void printResult() {
        System.out.println(ViewMessage.PRINT_BLANK.getMessage());
        System.out.println(ViewMessage.PRINT_RESULT.getMessage());
    }

    public void printRoundStatus(String status) {
        System.out.println(status);
    }

    public void printWinners(String result) {
        System.out.println(ViewMessage.PRINT_WINNERS.getMessage(result));
    }
}
