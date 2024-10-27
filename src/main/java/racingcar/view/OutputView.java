package racingcar.view;

public class OutputView {
    private static final String PLAY_RESULT_HEADING = "\n실행 결과";
    private static final String END_RESULT_HEADER = "최종 우승자 : ";

    public static void printGameResultHeader() {
        System.out.println(PLAY_RESULT_HEADING);
    }

    public static void printEachGameResult(String eachGameResult) {
        System.out.println(eachGameResult);
    }

    public static void printEndResult(String endResult) {
        System.out.println(END_RESULT_HEADER + endResult);
    }
}
