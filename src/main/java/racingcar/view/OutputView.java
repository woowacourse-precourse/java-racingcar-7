package racingcar.view;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_FORMAT = "%s : %s%n";
    private static final String FINAL_WINNER_FORMAT = "최종 우승자 : %s";

    public void printResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printRacingProgress(String name, String progress) {
        System.out.printf(RACING_FORMAT, name, progress);
    }

    public void printWinner(String winners) {
        System.out.printf(FINAL_WINNER_FORMAT, winners);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}