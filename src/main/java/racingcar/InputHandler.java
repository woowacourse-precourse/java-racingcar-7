package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String[] getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        return carNames;
    }
}
