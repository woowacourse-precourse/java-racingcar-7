package racingcar.view.validator.car;

import static racingcar.util.PreprocessingUtil.stringToStringList;

import java.util.List;
import racingcar.view.exception.NotEnoughCarException;

public class CarCountValidator extends CarNameInputValidator {

    private static final int MIN_CAR_COUNT = 2;

    private CarCountValidator() {
    }

    public static CarCountValidator initiate() {
        return new CarCountValidator();
    }

    @Override
    public void check(final String source) {
        List<String> cars = stringToStringList(source);
        if (cars.size() < MIN_CAR_COUNT) {
            throw new NotEnoughCarException(MIN_CAR_COUNT);
        }

        super.check(source);
    }
}
