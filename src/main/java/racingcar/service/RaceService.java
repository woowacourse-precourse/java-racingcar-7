package racingcar.service;

import java.util.List;
import racingcar.domain.CarDomain;
import racingcar.domain.RaceDomain;

public interface RaceService {
    void runRoundRace(RaceDomain race);
    List<CarDomain> getWinners(RaceDomain race);
}
