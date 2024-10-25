package racingcar.racing.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputConsole(boolean finalInputFlag) {
        String input = Console.readLine();
        if (finalInputFlag) {
            Console.close();
        }
        return input;
    }
}
