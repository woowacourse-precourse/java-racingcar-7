package racingcar.racing;

import java.util.List;

public interface Race<T extends Racer> {

    void start(List<T> racers);
}
