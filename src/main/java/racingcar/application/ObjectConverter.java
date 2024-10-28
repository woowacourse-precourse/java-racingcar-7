package racingcar.application;

import java.util.List;

public interface ObjectConverter<T> {

    List<T> toObjects(String value);
}
