package racingcar.view;

import java.util.List;

public class OutputView {

    public static final String LINE_BREAK = "\n";
    public static final String RUN_RESULT_MESSAGE = "실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void printRunResult() {
        System.out.println(LINE_BREAK + RUN_RESULT_MESSAGE);
    }

    public void printRoundResult(List<String> carStates) {
        carStates.forEach(System.out::println);
        System.out.println();
    }

    public void printFinalWinners(String winners) {
        System.out.println(FINAL_WINNER_MESSAGE + winners);
    }
}
