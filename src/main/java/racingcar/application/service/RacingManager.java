package racingcar.application.service;

import java.util.List;
import racingcar.vo.CarRaceResult;
import racingcar.domain.Racer;

public interface RacingManager<T extends Racer> {

    void registerAll(List<T> racers);

    void raceStart(int gameCount);

    CarRaceResult createRaceResult();
}
