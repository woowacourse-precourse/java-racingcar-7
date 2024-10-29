package racingcar.app.front.validator.car;

import static racingcar.app.front.preprocessor.input.CarNamePreprocessor.stringToStringList;
import static racingcar.app.server.model.car.Car.CAR_NAME_MIN_LENGTH;

import java.util.List;
import racingcar.app.server.exception.LengthExceedException;

public class CarNameLengthValidator extends CarNameInputValidator {

    private CarNameLengthValidator() {
    }

    public static CarNameLengthValidator initiate() {
        return new CarNameLengthValidator();
    }

    @Override
    public void check(final String source) {
        List<String> cars = stringToStringList(source);
        cars.forEach(name -> {
            if (exceedMinLength(name, CAR_NAME_MIN_LENGTH)) {
                throw new LengthExceedException(CAR_NAME_MIN_LENGTH);
            }
        });

        super.check(source);
    }

    private boolean exceedMinLength(String name, int length) {
        return name.length() > length;
    }
}
