package racingcar.domain;

import racingcar.exception.DuplicateNameException;
import racingcar.exception.MaxRacingCarCountException;

import java.util.List;

public class RacingCenter {

    private static final int CAR_COUNT_THRESHOLD = 10;

    public List<Car> registerCars(List<String> carNames) {
        validateUniqueName(carNames);
        validateRacingCarCount(carNames);
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateUniqueName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new DuplicateNameException();
        }
    }

    private void validateRacingCarCount(List<String> carNames) {
        if (carNames.size() > CAR_COUNT_THRESHOLD) {
            throw new MaxRacingCarCountException();
        }
    }
}
