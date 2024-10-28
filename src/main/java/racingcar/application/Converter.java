package racingcar.application;

import java.util.List;

public interface Converter<T> {

    List<T> toObjects(String value);
}
