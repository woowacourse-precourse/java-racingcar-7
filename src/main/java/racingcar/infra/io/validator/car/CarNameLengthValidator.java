package racingcar.infra.io.validator.car;

import static racingcar.util.PreprocessingUtil.stringToStringList;

import java.util.List;
import racingcar.infra.io.exception.CarNameLengthExceedException;

public class CarNameLengthValidator extends CarNameInputValidator {

    private static final int MIN_LENGTH = 5;

    private CarNameLengthValidator() {
    }

    public static CarNameLengthValidator initiate() {
        return new CarNameLengthValidator();
    }

    @Override
    public void check(final String source) {
        List<String> cars = stringToStringList(source);
        cars.forEach(name -> {
            if (exceedMinLength(name)) {
                throw new CarNameLengthExceedException(MIN_LENGTH);
            }
        });

        super.check(source);
    }

    private boolean exceedMinLength(String name) {
        return name.length() > MIN_LENGTH;
    }
}
