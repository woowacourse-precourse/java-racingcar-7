package racingcar.application.converter;

import java.util.List;
import racingcar.AppConfig;
import racingcar.domain.car.Car;
import racingcar.application.validation.Validator;

public class CarNamesConverter extends InputStringConverter<List<Car>> {

    private static final Validator validator = AppConfig.getInstance().carNameValidator();

    @Override
    protected List<Car> doConvert(String rawCarNames) {
        List<String> carNames = split(rawCarNames);

        return carNames.stream()
            .map(Car::new)
            .toList();
    }

    @Override
    protected void validate(String rawCarNames) {
        List<String> carNames = split(rawCarNames);
        carNames.forEach(validator::validate);
    }

    private List<String> split(String carNames) {
        return List.of(carNames.split(","));
    }
}
