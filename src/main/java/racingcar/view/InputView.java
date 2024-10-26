package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        return Console.readLine();
    }

    public static int getAttemptCount() {
        return Integer.parseInt(Console.readLine());
    }
}
