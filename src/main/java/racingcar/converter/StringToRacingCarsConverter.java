package racingcar.converter;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static java.util.stream.Collectors.toCollection;
import static racingcar.constant.RacingConstant.INPUT_CAR_NAMES_DELIMITER;
import static racingcar.constant.RacingConstant.RACING_CAR_MIN_COUNT;
import static racingcar.message.ErrorMessage.MINIMUM_REQUIRED_CARS;

public class StringToRacingCarsConverter {

    public LinkedHashSet<RacingCar> convert(String input) {
        LinkedHashSet<RacingCar> cars = convertInputToRacingCars(input);

        if (isInsufficientCarCount(cars)) {
            throw new IllegalArgumentException(MINIMUM_REQUIRED_CARS.getMessage());
        }

        return cars;
    }

    private LinkedHashSet<RacingCar> convertInputToRacingCars(String input) {
        return Arrays.stream(input.split(INPUT_CAR_NAMES_DELIMITER))
                .map(RacingCar::new)
                .collect(toCollection(LinkedHashSet::new));
    }

    private boolean isInsufficientCarCount(LinkedHashSet<RacingCar> cars) {
        return cars.size() < RACING_CAR_MIN_COUNT;
    }
}
