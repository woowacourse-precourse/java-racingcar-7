package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validation.CarsValidator;
import racingcar.validation.Validator;

public class CarsFactory {
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final int SPLIT_NO_LIMIT = -1;
    private static final Validator<List<Car>> validator = new CarsValidator();

    public static Cars createCars(String carNamesInput) {
        List<Car> cars = transferStringToCars(carNamesInput);
        validator.validate(cars);
        return new Cars(cars);
    }

    private static List<Car> transferStringToCars(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(CAR_NAMES_DELIMITER, SPLIT_NO_LIMIT))
                .map(CarFactory::createCar)
                .collect(Collectors.toList());
    }
}
