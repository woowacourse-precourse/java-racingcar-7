package racingcar.view;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void getCarName() {
        System.out.println(OutputMessage.TYPE_CAR_NAME.getMessage());
    }

    public void getAttemptCount() {
        System.out.println(OutputMessage.ASK_ATTEMPT_COUNT.getMessage());
    }

    public void runResult() {
        System.out.println(OutputMessage.RUN_RESULT.getMessage());
    }

    public void roundResult(String carName, String progress) {
        System.out.println(OutputMessage.ROUND_RESULT.getFormattedMessage(carName, progress));
    }

    public void winner(String winner) {
        System.out.println(OutputMessage.FINAL_WINNER.getFormattedMessage(winner));
    }
}
