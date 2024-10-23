package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputCarName() {
        return Console.readLine();
    }

    public static int inputTryCount() {
        return Integer.parseInt(Console.readLine());
    }
}
