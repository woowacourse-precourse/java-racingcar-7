package racingcar.utills;

import static racingcar.exception.Exception.INVALID_TRY_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputDevice {

    public static List<String> readStringListByDelimiter(String delimiter) {
        String input = Console.readLine();
        return StringParser.splitAndTrim(input, delimiter);
    }

    public static int readInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT.getMessage());
        }
    }
}
