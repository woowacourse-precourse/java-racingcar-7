package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPlayer() {
        String input = Console.readLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
