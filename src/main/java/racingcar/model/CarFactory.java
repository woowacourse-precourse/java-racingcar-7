package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.validator.CarNameValidator;

public class CarFactory {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    private static final String DELIMITER = ",";

    public List<Car> createCar(String rawCarNames) {
        Set<String> carNameSet = new HashSet<>();

        return Arrays.stream(rawCarNames.split(DELIMITER))
                .map(carName -> carNameValidator.checkCarName(carName, carNameSet))
                .map(Car::createCar)
                .toList();
    }
}
