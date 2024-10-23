package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String RACE_START_VIEW = "실행 결과";
    private static final String NAME_DELIMITER = " : ";
    private static final String WIN_INDICATOR = "-";
    private static final String WINNER_VIEW = "최종 우승자 : ";
    private static final String WINNERS_DELIMITER = ", ";

    public static void showRaceStart() {
        System.out.println("Race Start");
    }

    public static void showRaceResult(String carName, int winCount) {
        String result = WIN_INDICATOR.repeat(winCount);

        System.out.println(carName + NAME_DELIMITER + result);
    }

    public static void showNewLine() {
        System.out.println();
    }

    public static void showWinner(List<String> winners) {
        String result = String.join(WINNERS_DELIMITER, winners);

        System.out.println(WINNER_VIEW + result);
    }
}
