package racingcar.view;

import racingcar.domain.Race;
import racingcar.enums.ViewMessage;

public class OutputView {

    public void printResult() {
        System.out.println(ViewMessage.PRINT_BLANK.getMessage());
        System.out.println(ViewMessage.PRINT_RESULT.getMessage());
    }

    public void printRoundStatus(Race race) {
        System.out.println(race);
    }

    public void printWinners(String result) {
        System.out.println(ViewMessage.PRINT_WINNERS.getMessage(result));
    }
}
