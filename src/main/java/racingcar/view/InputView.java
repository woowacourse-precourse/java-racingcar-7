package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.constant.InputConstant;

public class InputView {
    public String CarNames() {
        System.out.println(InputConstant.INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public String NumberOfAttempt() {
        System.out.println(InputConstant.INPUT_ATTEMPT);
        return Console.readLine();
    }
}
