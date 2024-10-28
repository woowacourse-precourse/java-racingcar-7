package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.InputConstants;

public class InputView {

    public String inputCarsName() {
        System.out.println(InputConstants.INPUT_CAR_NAMES);
        String inputCarsName = Console.readLine();
        return inputCarsName;
    }

    public String inputCarRacingRepeatCount() {
        System.out.println(InputConstants.INPUT_REPEAT_COUNT);
        String inputCarRacingRepeatCount = Console.readLine();
        return inputCarRacingRepeatCount;
    }
}
