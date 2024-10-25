package racingcar.view;

import static racingcar.message.InputRequestMessage.NAMES_REQUEST_MESSAGE;

public class InputView {

    public void printCarNamesRequestMessage() {
        System.out.println(NAMES_REQUEST_MESSAGE.getMessage());
    }
}
