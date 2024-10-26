package racingcar.model;

import racingcar.common.Validator;

public record CarName(String carName) {

    public static CarName of(String carName) {

        Validator.validateCarNameLength(carName);
        return new CarName(carName);
    }
}
