package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String readInput(String includeMessage) {
        if (includeMessage != null) {
            System.out.println(includeMessage);
        }
        return readLineOrThrow();
    }

    private static String readLineOrThrow() {
        try {
            String input = Console.readLine();
            validateInput(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }
}
