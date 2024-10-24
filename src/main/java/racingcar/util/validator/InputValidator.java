package racingcar.util.validator;

public class InputValidator {

    public static void validate(String carNames, String tryCount) {
        CarNamesValidator.validate(carNames);
        TryCountValidator.validate(tryCount);
    }
}
