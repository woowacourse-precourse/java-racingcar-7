package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constants.Constants.*;

public class InputView {

    public static String inputCar() {
        System.out.println(INPUT_CAR_LIST_MESSAGE);
        return Console.readLine();
    }

    public static String inputRound() {
        System.out.println(INPUT_TRY_ROUND_MESSAGE);
        return Console.readLine();
    }
}
