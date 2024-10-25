package racingcar.view.io.write;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private OutputView() {
    }

    public static void printWithNewLineUpper(final String value) {
        newLine();
        simplePrint(value);
    }

    public static void printWithNewLineLower(final String value) {
        simplePrint(value);
        newLine();
    }

    public static void simplePrint(final String value) {
        System.out.println(value);
    }

    public static void closeConsole() {
        Console.close();
    }

    private static void newLine() {
        System.out.println();
    }
}
