package racingcar.io.output;

public interface Writer {

    void writeln(String message);

    void writeln();

    void write(String message);

    void writef(String format, Object... args);
}
