package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validation.CarsValidator;
import racingcar.validation.Validator;

public class Cars {
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final int SPLIT_NO_LIMIT = -1;

    private final List<Car> cars;
    private final Validator<Cars> validator;

    public Cars(String carNamesInput) {
        this.cars = registerCars(carNamesInput);
        this.validator = new CarsValidator();
        validator.validate(this);
    }

    private List<Car> registerCars(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(CAR_NAMES_DELIMITER, SPLIT_NO_LIMIT))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> moveCars() {
        cars.forEach(Car::move);
        return cars;
    }

    public List<String> findWinnerNames() {
        int maxMoveDistance = Collections.max(
                cars.stream()
                        .map(Car::getMoveDistance)
                        .collect(Collectors.toList())
        );
        return cars.stream()
                .filter(car -> car.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
