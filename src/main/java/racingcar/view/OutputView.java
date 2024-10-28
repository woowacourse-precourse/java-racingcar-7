package racingcar.view;

import racingcar.domain.Name;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DASH = "-";

    public static void startPrintResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(String name, int distance) {
        System.out.println(name + " : " + DASH.repeat(distance));
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(String.join(", ", winners));
    }

    public static void printEmptyLine() {
        System.out.println();
    }

}
