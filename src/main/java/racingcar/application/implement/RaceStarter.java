package racingcar.application.implement;

import java.util.List;
import racingcar.domain.Racer;

public interface RaceStarter<T extends Racer> {

    void start(List<T> racers);
}
