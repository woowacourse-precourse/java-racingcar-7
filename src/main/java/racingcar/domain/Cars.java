package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public class Cars {
    private static final int MIN_CAR_COUNT = 2;
    private final List<Car> raceCars = new ArrayList<>();

    public Cars(List<String> carNames) {
        validateCarNameUniqueness(carNames);
        validateCarCount(carNames);
        initializeCars(carNames);
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : raceCars) {
            car.move(numberGenerator);
        }
    }

    private void validateCarNameUniqueness(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw RacingCarGameException.from(ErrorMessage.DUPLICATE_CAR_NAMES);
        }
    }

    private void validateCarCount(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT) {
            throw RacingCarGameException.from(ErrorMessage.INSUFFICIENT_CAR_COUNT);
        }
    }

    private void initializeCars(List<String> carNames) {
        for (String carName : carNames) {
            raceCars.add(new Car(carName));
        }
    }
}