package racingcar.view;

import racingcar.constant.OutputMessage;

public class OutputView {

    public void printCarNameMessage() {
        System.out.println(OutputMessage.CAR_NAME_INPUT_GUIDE.getMessage());
    }

    public void printTryCountMessage() {
        System.out.println(OutputMessage.TRY_COUNT_GUIDE.getMessage());
    }
}
