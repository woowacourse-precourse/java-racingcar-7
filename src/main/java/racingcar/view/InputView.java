package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getInput() {
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
