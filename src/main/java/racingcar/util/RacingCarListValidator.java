package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class RacingCarListValidator implements ListValidator<Car> {


    @Override
    public void validateDuplicate(final List<Car> values) {
        if (isDuplicateCar(values)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateSize(final List<Car> values, final int maxSize) {
        if (isExceedMaxSize(values, maxSize)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isExceedMaxSize(final List<Car> values, final int maxSize) {
        return values.size() > maxSize;
    }

    private boolean isDuplicateCar(final List<Car> values) {
        return values.stream()
                .distinct()
                .count() != values.size();
    }
}
