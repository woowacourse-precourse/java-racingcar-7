package racingcar.util;

import java.util.List;

public class RacingCarListValidator implements ListValidator<String> {


    @Override
    public void validateDuplicate(final List<String> values) {
        if (isDuplicateCar(values)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateSize(final List<String> values, final int maxSize) {
        if (isExceedMaxSize(values, maxSize)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isExceedMaxSize(final List<String> values, final int maxSize) {
        return values.size() > maxSize;
    }

    private boolean isDuplicateCar(final List<String> values) {
        return values.stream()
                .distinct()
                .count() != values.size();
    }
}
