package racingcar.io.output;

public class CliOutputWriter implements Writer {

    @Override
    public void writeln(String message) {
        System.out.println(message);
    }

    @Override
    public void writeln() {
        System.out.println();
    }

    @Override
    public void write(String message) {
        System.out.print(message);
    }

    @Override
    public void writef(String format, Object... args) {
        System.out.printf(format, args);
    }
}
