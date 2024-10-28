package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readCarName() {
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return input;
    }

    public String readTryCount() {
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        return input;
    }
}
