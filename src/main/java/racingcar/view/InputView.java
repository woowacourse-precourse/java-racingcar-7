package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCarNames() {
        return Console.readLine();
    }

    public static int inputMoveCount() {
        return Integer.parseInt(Console.readLine());
    }
}
