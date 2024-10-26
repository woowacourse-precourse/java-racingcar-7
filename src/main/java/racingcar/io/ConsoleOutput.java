package racingcar.io;

public class ConsoleOutput implements Output {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
