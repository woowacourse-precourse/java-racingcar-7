package racingcar.application.converter;

import java.util.List;
import racingcar.AppConfig;
import racingcar.application.validation.Validator;
import racingcar.domain.car.Car;

public class CarNamesConverter extends InputStringConverter<List<Car>> {

    private static final Validator validator = AppConfig.getInstance().carNamesValidator();

    @Override
    protected List<Car> doConvert(String rawString) {
        List<String> carNames = splitToList(rawString);

        return carNames.stream()
            .map(Car::new)
            .toList();
    }

    @Override
    protected void validate(String rawString) {
        validator.validate(rawString);
    }

    private List<String> splitToList(String rawString) {
        return List.of(rawString.split(","));
    }
}
