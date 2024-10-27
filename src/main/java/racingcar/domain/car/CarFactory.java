package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.StringConstants;

public class CarFactory {

    public List<Car> create(String carNames) {
        return Arrays.stream(carNames.split(StringConstants.CAR_NAME_SEPARATOR))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }
}