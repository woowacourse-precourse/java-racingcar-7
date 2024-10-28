package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/** IllegalArgumentException 을 던지기 위한 Console 래퍼 */
public class OhMyConsole {

    public static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Input cannot be read: " + e.getMessage(), e);
        }
    }

    public static void close() {
        Console.close();
    }
}
