package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCarNames() {
        return Console.readLine();
    }

    public static int readAttemptCount() {
        return Integer.parseInt(Console.readLine());
    }
}
