package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.InputOutputConstants.INPUT_CAR_MESSAGE;
import static racingcar.constant.InputOutputConstants.INPUT_TRIAL_MESSAGE;

public class InputView {
    public static String userInputCar(){
        System.out.println(INPUT_CAR_MESSAGE);
        return Console.readLine();
    }

    public static String userInputTrial(){
        System.out.println(INPUT_TRIAL_MESSAGE);
        return Console.readLine();
    }

}
