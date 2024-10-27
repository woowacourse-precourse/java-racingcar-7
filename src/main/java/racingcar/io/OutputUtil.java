package racingcar.io;

public class OutputUtil {
    private final static OutputUtil instance = new OutputUtil();

    private OutputUtil() {
    }

    public static OutputUtil getInstance() {
        return instance;
    }

    public void println(String string) {
        System.out.println(string);
    }

    public void print(String string) {
        System.out.print(string);
    }
}
