package racingcar.view;

import static racingcar.constant.InputOutputConstants.INPUT_CAR_MESSAGE;
import static racingcar.constant.InputOutputConstants.INPUT_TRIAL_MESSAGE;
import static racingcar.constant.InputOutputConstants.RUN_MESSAGE;
import static racingcar.constant.InputOutputConstants.END_LINE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String userInputCar() {

        System.out.println(INPUT_CAR_MESSAGE);
        return Console.readLine();
    }

    public static String userInputTrial() {

        System.out.println(INPUT_TRIAL_MESSAGE);
        String tmp = Console.readLine();
        System.out.println(RUN_MESSAGE + END_LINE);
        return tmp;
    }

}
