package racingcar.validation;

import racingcar.constant.NumberConstant;

public class ProcessValid {

    public static boolean isRunCar(int randomNum) {
        return randomNum >= NumberConstant.SET_VALUE;
    }
}
