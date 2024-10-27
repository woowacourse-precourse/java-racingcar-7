package racingcar.model;

import racingcar.common.Validator;

public record CarName(String carName) {

    public static CarName of(String carName) {
        Validator.validateCarNameLength(carName);
        Validator.validateIsContainNewLine(carName);
        Validator.validateCarNameIsNotEmpty(carName);
        Validator.validateCarNameContainBlank(carName);
        return new CarName(carName);
    }
}
