package racingcar.view;

import racingcar.constants.MessageConstants;

public class OutputView {

    public static  void requestCarNames() {
        System.out.print(MessageConstants.INPUT_CAR_NAMES);
    }

    public static void requestAttemptCount() {
        System.out.print(MessageConstants.INPUT_ATTEMPT_COUNT);
    }

    public static void printExecutionResult() {
        System.out.print(MessageConstants.EXECUTION_RESULT);
    }

    public static void printWinners(String winners) {
        System.out.print(MessageConstants.FINAL_WINNER + winners);
    }

}
