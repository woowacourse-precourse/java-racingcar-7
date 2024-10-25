package racingcar.mvc.view;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void showExecutionResultMsg() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void showFinalWinnerMsg() {
        System.out.print(FINAL_WINNER_MESSAGE);
    }
}
