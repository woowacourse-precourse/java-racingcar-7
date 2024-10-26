package racingcar.View;

import racingcar.Model.Car;

public class Output {
    public static void validatorCarNames(String carName) {
        if(carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException();
        }
    }


}
