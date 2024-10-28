package racingcar.view;

public class OutputView {

    private static final String EXECUTE_RESULT_PREFIX = "\n실행결과\n";
    private static final String FINAL_WINNER_PREFIX = "최종 우승자 : ";

    public void printExecuteResult(String executeResult) {
        System.out.println(EXECUTE_RESULT_PREFIX + executeResult);
    }

    public void printFinalResult(String result) {
        System.out.println(FINAL_WINNER_PREFIX + result);
    }
}