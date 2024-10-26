package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Message;

public class OutputView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printResult(Message resultMessage) {
        System.out.println(RESULT_MESSAGE + System.lineSeparator() + resultMessage.getMessage());
    }

    public void printWinner(Message winnerMessage) {
        System.out.println(WINNER_MESSAGE + winnerMessage.getMessage());
    }

    public void close() {
        Console.close();
    }
}
