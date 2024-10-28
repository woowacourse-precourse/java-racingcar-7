package racingcar.view;

import static racingcar.view.constants.ViewMessage.INPUT_CAR_NAMES;
import static racingcar.view.constants.ViewMessage.INPUT_ROUND;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCarNames() {
        System.out.println(INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public static Integer getRound() {
        System.out.println(INPUT_ROUND.getMessage());
        String roundInput = Console.readLine();
        return Integer.parseInt(roundInput);
    }
}
