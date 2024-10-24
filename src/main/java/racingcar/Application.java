package racingcar;

public class Application {
    public static void main(String[] args) {
        Printer.printMessage(Constants.INPUT_NAMES);
        Parser parser = new Parser(Reader.readInput());
        parser.parseInput();
    }
}
