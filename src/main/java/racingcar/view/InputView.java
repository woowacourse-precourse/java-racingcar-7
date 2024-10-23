package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        System.out.println(ViewMessage.INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println(ViewMessage.INPUT_TRY_COUNT.getMessage());
        return Console.readLine();
    }


}
