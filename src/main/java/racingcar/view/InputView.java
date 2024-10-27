package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.RunMessage;

public class InputView {

    public String inputCarNames() {
        System.out.print(RunMessage.INPUT_CAR.getMessage());
        return Console.readLine();
    }
}
