package racingcar.view;

import racingcar.message.SystemMessage;

public class OutputView {

    public static void printSetCarNameMessage() {
        System.out.println(SystemMessage.INPUT_CAR_NAME_MESSAGE.getMessage());
    }

}
