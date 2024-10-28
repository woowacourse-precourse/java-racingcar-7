package racingcar.util;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreatingRacingCar {
    private static final int START_LOCATION = 0;

    public static RacingCars createCars(final String[] carNames) {
        List<RacingCar> cars = makeCars(carNames);
        return new RacingCars(cars);
    }
    private static List<RacingCar> makeCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(CreatingRacingCar::makeCar)
                .collect(Collectors.toList());
    }
    private static RacingCar makeCar(final String carName) {
        return new RacingCar(carName, START_LOCATION);
    }
}
