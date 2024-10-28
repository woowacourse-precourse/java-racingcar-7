package racingcar.persistence;

import java.util.List;
import racingcar.racing.CarRacer;

public interface RacingCarRepository {

    List<CarRacer> getAll();

    void addAll(List<CarRacer> carRacers);

    void clear();
}
