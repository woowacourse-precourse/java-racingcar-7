package racingcar.domain;

import static racingcar.exception.Exception.NOT_POSITIVE_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static final int MINIMUM_TRY_COUNT = 1;
    private final RacingCars cars;
    private final int remainingTryCount;
    private final List<String> snapshot;

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
}
