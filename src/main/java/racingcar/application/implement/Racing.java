package racingcar.application.implement;

import java.util.List;
import racingcar.domain.Racer;

public interface Racing<T extends Racer> {

    void start(List<T> racers);
}
