package racingcar.util.validator;

import java.util.List;
import racingcar.constant.ErrorType;

public class RacingCarListValidator implements ListValidator<String> {


    @Override
    public void validateDuplicate(final List<String> values) {
        if (isDuplicateCar(values)) {
            throw new IllegalArgumentException(ErrorType.DUPLICATE_CAR_NAME);
        }
    }

    @Override
    public void validateSize(final List<String> values, final int maxSize) {
        if (isExceedMaxSize(values, maxSize)) {
            throw new IllegalArgumentException(ErrorType.EXCEEDED_MAX_CARS_SIZE);
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
