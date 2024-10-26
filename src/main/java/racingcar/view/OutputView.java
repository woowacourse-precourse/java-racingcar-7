package racingcar.view;

import racingcar.enums.IOMessages;

public class OutputView {
    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void roundResultHeader() {
        System.out.println(IOMessages.ROUND_RESULT_HEADER.getMsg());
    }

    public void printRoundResult(String currentStatus) {
        System.out.println(currentStatus);
    }
}
