package racingcar.service;

import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;

public interface RaceService {
    void runOneRound(RaceDomain race);

    CarDomains getWinners(RaceDomain race);
}
