package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validate.RepetitionCountValidator;

public class Input {

    public static int inputRepetition() {
        String input = Console.readLine();

        RepetitionCountValidator.validateRepetitionCount(input);

        return Integer.parseInt(input);
    }

    public static List<String> inputCarNames() {
        String input = Console.readLine();
        return splitCarNames(input);
    }

    public static void close() {
        Console.close();
    }

    private static List<String> splitCarNames(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
