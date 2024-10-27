package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputCarNames() {
        return Console.readLine();
    }

    public static String inputTryCount() {
        return Console.readLine();
    }
}
