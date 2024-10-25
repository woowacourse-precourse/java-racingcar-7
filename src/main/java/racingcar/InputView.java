package racingcar;

import static racingcar.ViewConstants.TOTAL_ATTEMPTS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestTotalAttempts() {
        System.out.println(TOTAL_ATTEMPTS_MESSAGE);
        return Console.readLine();
    }
}
