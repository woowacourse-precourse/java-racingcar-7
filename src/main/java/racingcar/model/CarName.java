package racingcar.model;

import racingcar.common.Validator;

import static racingcar.common.Validator.validateIsContainNewLine;

public record CarName(String carName) {

    public static CarName of(String carName) {

        Validator.validateCarNameLength(carName);
        validateIsContainNewLine(carName);
        return new CarName(carName);
    }
}
