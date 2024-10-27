package racingcar.application.converter;

import racingcar.AppConfig;
import racingcar.io.validation.Validator;

public class CountConverter extends InputStringConverter<Integer> {

    private static final Validator validator = AppConfig.getInstance().countValidator();

    @Override
    protected Integer doConvert(String count) {
        return Integer.parseInt(count);
    }

    @Override
    protected void validate(String count) {
        validator.validate(count);
    }
}
