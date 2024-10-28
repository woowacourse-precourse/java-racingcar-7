package racingcar.racing;

import java.util.List;

public interface Racing<T extends Racer> {

    void start(List<T> racers);
}
