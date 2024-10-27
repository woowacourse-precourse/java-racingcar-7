package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {
    private final static InputUtil instance = new InputUtil();

    private InputUtil() {
    }

    public static InputUtil getInstance() {
        return instance;
    }

    public String InputString() {
        return readLine();
    }
}
