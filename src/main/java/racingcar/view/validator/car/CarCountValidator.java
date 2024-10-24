package racingcar.view.validator.car;

import static java.util.Objects.isNull;
import static racingcar.util.PreprocessingUtil.stringToStringList;

import java.util.List;
import java.util.Objects;
import racingcar.view.exception.EmptyInputException;
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
        if (isNull(source)) {
            throw new EmptyInputException();
        }

        List<String> cars = stringToStringList(source);
        if (cars.size() < MIN_CAR_COUNT) {
            throw new NotEnoughCarException(MIN_CAR_COUNT);
        }

        boolean hasNullObject = cars.stream().anyMatch(Objects::isNull);
        if (hasNullObject) {
            throw new EmptyInputException();
        }

        super.check(source);
    }
}
