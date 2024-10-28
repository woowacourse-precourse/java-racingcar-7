package racingcar.application.service;

import java.util.List;
import racingcar.domain.Racer;
import racingcar.vo.RaceResult;

public interface RacingManager<T extends Racer> {

    void registerAll(List<T> racers);

    void raceStart(int gameCount);

    RaceResult<T> createRaceResult();
}
