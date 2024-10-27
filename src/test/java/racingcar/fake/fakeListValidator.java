package racingcar.fake;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.validator.ListValidator;

public class fakeListValidator implements ListValidator<Car> {

    @Override
    public void validateDuplicate(final List<Car> values) {
        // fake
    }

    @Override
    public void validateSize(final List<Car> values, final int maxSize) {
        // fake
    }
}
