package racingcar.view;

public class OutputView {
    private static final String PLAY_RESULT_HEADING = "\n실행 결과";

    public static void printGameResultHeader() {
        System.out.println(PLAY_RESULT_HEADING);
    }

    public static void printEachGameResult(String eachGameResult) {
        System.out.println(eachGameResult);
    }
}
