package racingcar;

import static racingcar.ViewConstants.ENTER_CAR_NAMES_MESSAGE;
import static racingcar.ViewConstants.ENTER_TOTAL_ROUNDS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestCarNames() {
        System.out.println(ENTER_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String requestTotalAttempts() {
        System.out.println(ENTER_TOTAL_ROUNDS_MESSAGE);
        return Console.readLine();
    }
}
