package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Message;

public class InputView {
    public String inputCarNames() {
        System.out.println(Message.ENTER_CAR_NAMES);
        return Console.readLine();
    }

    public String inputRoundNumber() {
        System.out.println(Message.ENTER_ROUND_NUMBER);
        return Console.readLine();
    }
}
