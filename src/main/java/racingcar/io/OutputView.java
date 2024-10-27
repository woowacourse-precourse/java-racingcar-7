package racingcar.io;

import static racingcar.global.constant.Message.READ_CAR_NAME_MESSAGE;

public class OutputView {
    public void printReadCarNameMessage() {
        println(READ_CAR_NAME_MESSAGE);
    }

    public void println(String string) {
        System.out.println(string);
    }
}
