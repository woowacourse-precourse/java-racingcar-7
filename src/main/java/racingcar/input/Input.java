package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public static String input() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }

    public static List<String> splitCar(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
