package racingcar.application;

import java.util.List;
import racingcar.racing.CarRaceResult;
import racingcar.racing.Racer;

public interface RacingManager<T extends Racer> {

    void registerAll(List<T> racers);

    void raceStart(int gameCount);

    CarRaceResult createRaceResult();
}
