package racingcar;

public class Initializer {
    public static void initData() {
        initNames();
        initCount();
    }

    private static void initNames() {
        Printer.printMessage(Constants.INPUT_NAMES);
        Parser.parseNames(Reader.readInput());
    }

    private static void initCount() {
        Printer.printMessage(Constants.INPUT_COUNT);
        Parser.parseCount(Reader.readInput());
    }
}