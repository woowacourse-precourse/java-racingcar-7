package racingcar.common.support;

import java.util.List;

public interface ObjectConverter<T> {

    List<T> toObjects(String value);

    String toStringNames(List<T> winners);
}
