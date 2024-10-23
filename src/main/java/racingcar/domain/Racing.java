package racingcar.domain;

import static racingcar.exception.Exception.NOT_POSITIVE_NUMBER;

import java.util.List;

public class Racing {

    public static final int MINIMUM_TRY_COUNT = 1;
    private final RacingCars cars;
    private final int remainingTryCount;

    private Racing(final RacingCars cars, final int tryCount) {
        this.cars = cars;
        this.remainingTryCount = tryCount;
    }

    public static Racing of(final List<String> carNames, final int tryCount) {
        validate(tryCount);
        RacingCars cars = RacingCars.of(carNames);
        return new Racing(cars, tryCount);
    }

    private static void validate(final int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER.getMessage());
        }
    }
}
