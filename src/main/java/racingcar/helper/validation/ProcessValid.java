package racingcar.helper.validation;

import racingcar.config.constant.NumberConstant;

public class ProcessValid {

    public static boolean isRunCar(int randomNum) {
        return randomNum >= NumberConstant.SET_VALUE;
    }
}
