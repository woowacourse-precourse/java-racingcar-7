package racingcar.io;

import static racingcar.global.constant.Message.READ_CAR_NAME_MESSAGE;
import static racingcar.global.constant.Message.READ_MOVEMENT_NUMBER_MESSAGE;

public class OutputView {
    public void printCarNameMessage() {
        println(READ_CAR_NAME_MESSAGE);
    }

    public void printMovementNumberMessage() {
        println(READ_MOVEMENT_NUMBER_MESSAGE);
    }

    public void println(String string) {
        System.out.println(string);
    }
}
