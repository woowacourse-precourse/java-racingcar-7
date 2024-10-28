package racingcar.View;

import racingcar.View.constant.OutputMessage;

public class OutputView {
    public void printMessage(OutputMessage Message) {
        System.out.println(Message.getMessage());
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printBlank() {
        System.out.println(" ");
    }
}
