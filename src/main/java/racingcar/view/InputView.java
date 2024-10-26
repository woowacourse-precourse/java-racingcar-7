package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InputMessage;

public class InputView {
    public static String getCarNameInput() {
        System.out.println(InputMessage.CAR_NAME_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getRoundCountInput() {
        System.out.println(InputMessage.ROUND_COUNT_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
