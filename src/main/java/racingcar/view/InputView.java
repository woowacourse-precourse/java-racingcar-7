package racingcar.view;

import static racingcar.constant.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNamesInput() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getAttemptCountInput() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }
}
