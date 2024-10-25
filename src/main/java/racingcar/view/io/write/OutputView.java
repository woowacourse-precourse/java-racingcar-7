package racingcar.view.io.write;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private OutputView() {
    }

    public static void print(final String value) {
        System.out.println(value);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void closeConsole() {
        Console.close();
    }
}
