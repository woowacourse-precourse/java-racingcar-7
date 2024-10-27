package racingcar.io.input;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.exception.ExceptionMessage.INPUT_BLANK;

public class CliInputReader implements Reader {

    @Override
    public String readLine() {
        String input = Console.readLine().strip();

        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_BLANK.getMessage());
        }
    }
}
