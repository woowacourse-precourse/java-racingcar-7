package racingcar.fake;

import java.util.List;
import racingcar.util.validator.ListValidator;

public class FakeListValidator implements ListValidator<String> {

    @Override
    public void validateDuplicate(final List<String> values) {
        // fake
    }

    @Override
    public void validateSize(final List<String> values, final int maxSize) {
        // fake
    }
}
