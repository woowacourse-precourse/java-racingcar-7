package racingcar.observer;

import java.util.List;
import racingcar.model.Car;

public interface Observer {
    void update(List<Car> list);
}
