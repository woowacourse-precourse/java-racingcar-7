package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.view.enumerate.ErrorOutputConstant.ABRUPT_ERROR;
import static racingcar.view.enumerate.ErrorOutputConstant.INPUT_TRY_TIME_UNDER_1_ERROR;

public class InputView {
    public String inputCarName() {
        return Console.readLine();
    }

    public int inputRaceTryTimes() {
        try {
            int inputTryTimes = Integer.parseInt(Console.readLine());
            if (inputTryTimes < 0) {
                throw new IllegalArgumentException(INPUT_TRY_TIME_UNDER_1_ERROR.getSentence());
            }
            return inputTryTimes;
        } catch (Exception e) {
            throw new IllegalArgumentException(ABRUPT_ERROR.getSentence());
        }
    }
}
