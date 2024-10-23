package racingcar.view.output;

import java.util.List;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printRound(List<String> roundResults) {
        for (String roundResult : roundResults) {
            System.out.println(roundResult);
        }
    }
}
