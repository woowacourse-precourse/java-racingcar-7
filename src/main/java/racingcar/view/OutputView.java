package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printOutput(String format, List<String> output) {
        System.out.printf(format, String.join(", ", output));
    }
}