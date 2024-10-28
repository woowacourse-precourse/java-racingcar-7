package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getString() {
        String input = Console.readLine();
        validateEmptyString(input);

        return input;
    }

    private void validateEmptyString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public int getPositiveInteger() {
        String input = getString();
        validateDigitFormat(input);

        return toInteger(input);
    }

    private void validateDigitFormat(String input) {
        if (input.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
