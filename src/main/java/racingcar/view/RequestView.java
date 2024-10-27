package racingcar.view;

import static racingcar.message.InfoMessage.REQUEST_NAMES_MESSAGE;
import static racingcar.message.InfoMessage.REQUEST_NUMBER_MESSAGE;

public class RequestView {
    public static void requestNames() {
        System.out.println(REQUEST_NAMES_MESSAGE.getMessage());
    }

    public static void requestMoveNumber() {
        System.out.println(REQUEST_NUMBER_MESSAGE.getMessage());
    }
}
