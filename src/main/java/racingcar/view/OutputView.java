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

    public static void printResult(Name name, int distance) {
        System.out.println(name + " : " + DASH.repeat(distance));
    }

    public static void printWinners(List<Name> winners) {
        System.out.println(WINNER_MESSAGE + winners);
    }

}
