package racingcar.view;

import racingcar.constant.Message;

public class OutputView {

    public void printErrorMessage(String errorMessage) {
        System.out.println(Message.ERROR_PREFIX + errorMessage);
    }

    public void printRunResult(String runResult) {
        System.out.println(Message.RUN_RESULT_MESSAGE);
        System.out.println(runResult);
    }

    public void printWinnerResult(String winners) {
        System.out.println(Message.WINNER_RESULT_MESSAGE + winners);
    }
}
