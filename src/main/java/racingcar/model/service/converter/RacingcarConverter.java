package racingcar.model.service.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;

public class RacingcarConverter {

    private static final Character DELIMITER = ',';

    public List<Car> convertToCars(String carNames) {
        return Arrays.stream(carNames.split(String.valueOf(DELIMITER)))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Integer convertToNumber(String attemptCountInput) {
        return Integer.parseInt(attemptCountInput);
    }
}
