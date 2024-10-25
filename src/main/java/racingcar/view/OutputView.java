package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printResult(String resultMessage) {
        System.out.println(RESULT_MESSAGE + System.lineSeparator() + resultMessage);
    }

    public void printWinner(String winnerMessage) {
        System.out.println(WINNER_MESSAGE + winnerMessage);
    }

    public void close() {
        Console.close();
    }
}
