package racingcar.io;

public class OutputManager {
    private static OutputManager instance;
    private Output output;

    private OutputManager() {
        output = new ConsoleOutput();
    }

    public static OutputManager getInstance() {
        if (instance == null) {
            instance = new OutputManager();
        }
        return instance;
    }

    public void print(String message) {
        output.print(message);
    }
}
