package racingcar.controller.validator;

import java.util.List;

public class ValidatorFactory {

    public Validator<List<String>> getCarValidator() {
        return new CarValidator();
    }

    public Validator<Integer> getRoundValidator() {
        return new RoundValidator();
    }
}
