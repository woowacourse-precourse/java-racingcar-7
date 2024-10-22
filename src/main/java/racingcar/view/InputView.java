package racingcar.view;

import static racingcar.view.constants.ViewMessage.INPUT_CAR_NAMES;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCarNames() {
        System.out.println(INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }
}
