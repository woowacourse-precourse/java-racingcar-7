package racingcar.app.front.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    private OutputView() {
    }

    public static class OutputViewHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.INSTANCE;
    }

    public void printWithNewLineUpper(final String value) {
        newLine();
        simplePrint(value);
    }

    public void printWithNewLineLower(final String value) {
        simplePrint(value);
        newLine();
    }

    public void simplePrint(final String value) {
        System.out.println(value);
    }

    public void closeConsole() {
        Console.close();
    }

    private void newLine() {
        System.out.println();
    }
}
