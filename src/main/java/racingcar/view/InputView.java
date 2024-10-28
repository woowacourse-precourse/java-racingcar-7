package racingcar.view;

import static racingcar.enums.Message.INPUT_ATTEMPTS;
import static racingcar.enums.Message.INPUT_CAR_NAMES;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public String inputAttempts() {
        System.out.println(INPUT_ATTEMPTS.getMessage());
        return Console.readLine();
    }
}
