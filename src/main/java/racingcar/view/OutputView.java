package racingcar.view;

import racingcar.constant.Message;

public class OutputView {

    public void printErrorMessage(String errorMessage) {
        System.out.println(Message.ERROR_PREFIX + errorMessage);
    }
}
