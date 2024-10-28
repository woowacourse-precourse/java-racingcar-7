package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.util.InputCarsValidator;

public class Cars {

    public static final String REGEX_THAT_IGNORES_SPACES_BEFORE_AND_AFTER_COMMAS = "\\s*,\\s*";

    public List<Car> extractValidCars(String carNames) {

        InputCarsValidator.isEmpty(carNames);

        List<Car> cars = createCarNameList(carNames);

        InputCarsValidator.hasDuplicate(cars);

        return cars;
    }

    private List<Car> createCarNameList(String carNames) {

        return Arrays.stream(carNames.split(REGEX_THAT_IGNORES_SPACES_BEFORE_AND_AFTER_COMMAS, -1))
                .map(Car::new)
                .toList();
    }


}
