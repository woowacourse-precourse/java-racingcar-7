package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.IOMessages;

public class InputView {
    public String inputCarName() {
        System.out.println(IOMessages.INPUT_NAMES.getMsg());
        return Console.readLine();
    }

    public String inputRepeatTimes() {
        System.out.println(IOMessages.INPUT_REPEAT_TIMES.getMsg());
        return Console.readLine();
    }
}
