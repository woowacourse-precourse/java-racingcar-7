package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getString() {
        return Console.readLine();
    }

    public int getInteger() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
