package racingcar.view;

import racingcar.constants.ViewMessage;

public class InputView {

    public static void showInputPrompt(ViewMessage viewMessage) {
        System.out.println(viewMessage.getMessage());
    }

}