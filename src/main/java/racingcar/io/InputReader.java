package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.InputValidator;

public class InputReader {

    public List<String> carName() {
        String input = readInput();
        InputValidator.validateCarNames(input);
        return List.of(input.split(","));
    }

    public int attemptCount() {
        String input = readInput();
        InputValidator.validateAttemptCount(input);
        return Integer.parseInt(input);
    }

    private String readInput() {
        return Console.readLine();
    }

}
