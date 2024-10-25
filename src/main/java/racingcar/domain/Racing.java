package racingcar.domain;

import static racingcar.exception.Exception.NOT_POSITIVE_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static final int MINIMUM_TRY_COUNT = 1;
    private final RacingCars cars;
    private final List<String> snapshot;
    private int remainingTryCount;

    public Racing(final RacingCars cars, final int tryCount) {
        validate(tryCount);
        this.cars = cars;
        this.remainingTryCount = tryCount;
        this.snapshot = new ArrayList<>();
    }

    private static void validate(final int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    public RacingResult play() {
        if (remainingTryCount < MINIMUM_TRY_COUNT) {
            return new RacingResult(cars, snapshot);
        }

        race();
        remainingTryCount--;
        return play();
    }

    private void race() {
        cars.move();
        snapshot.add(cars.toString());
    }

}
