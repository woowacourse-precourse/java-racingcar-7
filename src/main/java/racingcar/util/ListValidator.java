package racingcar.util;

import java.util.List;

public interface ListValidator<T> {

    void validateDuplicate(final List<T> values);
    void validateSize(final List<T> values, final int maxSize);
}
