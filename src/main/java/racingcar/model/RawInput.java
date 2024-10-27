package racingcar.model;

import racingcar.common.Validator;

public record RawInput(String rawInput) {

    public static RawInput of(String rawInput) {
        Validator.validateRawInputHasCommaInLast(rawInput);
        return new RawInput(rawInput);
    }
}
