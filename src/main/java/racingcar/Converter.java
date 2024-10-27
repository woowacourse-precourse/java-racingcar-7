package racingcar;

import java.util.List;

public interface Converter<T> {

    List<T> toObjects(String value);
}
