package racingcar.View;

import static racingcar.View.constant.OutputMessage.ROUND_START_MESSAGE;
import static racingcar.View.constant.OutputMessage.START_MESSAGE;

public class OutputView {
    public void printStart() {
        System.out.println(START_MESSAGE.getMessage());
    }

    public void printRoundStart() {
        System.out.println(ROUND_START_MESSAGE.getMessage());
    }
}
