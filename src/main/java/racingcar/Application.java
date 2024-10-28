package racingcar;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();

        consoleOutput.printInputCarName();
        String carName = consoleInput.inputString();

        consoleOutput.printInputTryCount();
        Integer carTryCount = consoleInput.inputNumber();

    }
}
