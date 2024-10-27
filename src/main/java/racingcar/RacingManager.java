package racingcar;

import java.util.List;

public interface RacingManager<T extends Racer> {

    void registerAll(List<T> racers);
}
