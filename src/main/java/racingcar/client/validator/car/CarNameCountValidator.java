package racingcar.client.validator.car;

import static racingcar.client.preprocessor.car.CarNamePreprocessor.stringToStringList;

import java.util.List;
import racingcar.client.exception.NotEnoughCarException;

public class CarNameCountValidator extends CarNameInputValidator {

    private static final int MIN_CAR_COUNT = 2;

    private CarNameCountValidator() {
    }

    public static CarNameCountValidator initiate() {
        return new CarNameCountValidator();
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
