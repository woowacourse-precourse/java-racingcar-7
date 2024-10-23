package racingcar.view;

public class OutputView {

    private static final String RACE_START_VIEW = "실행 결과";
    private static final String NAME_DELIMITER = " : ";
    private static final String WIN_INDICATOR = "-";

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
}
