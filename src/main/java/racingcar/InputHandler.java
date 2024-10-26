package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private final InputValidator inputValidator;

    public InputHandler(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> getCarNames() {
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(InputValidator::validateCarName).toList();
    }
}
