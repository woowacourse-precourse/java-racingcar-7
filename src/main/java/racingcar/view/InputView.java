package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Constants;

public class InputView {
    public String getInputNames() {
        System.out.println(Constants.INPUT_NAME_MESSAGE);
        return Console.readLine();
    }

    public String getInputCount() {
        System.out.println(Constants.INPUT_COUNT_MESSAGE);
        return Console.readLine();
    }
}
