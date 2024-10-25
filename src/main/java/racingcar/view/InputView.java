package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {}

    public static String input() {
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
