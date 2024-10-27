package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Message;

public class OutputView {
    public void printResult(Message resultMessage) {
        System.out.println(resultMessage.getMessage());
    }

    public void printWinner(Message winnerMessage) {
        System.out.println(winnerMessage.getMessage());
    }

    public void close() {
        Console.close();
    }
}
