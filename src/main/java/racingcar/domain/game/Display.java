package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;

public interface Display {
    void progress(List<Car> cars);
    void winners(List<Car> winners);
}
