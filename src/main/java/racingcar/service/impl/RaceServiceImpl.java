package racingcar.service.impl;

import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;
import racingcar.service.RaceService;

public class RaceServiceImpl implements RaceService {
    @Override
    public void runOneRound(RaceDomain race) {
        race.executeOneRound();
    }

    @Override
    public CarDomains getWinners(RaceDomain race) {
        return race.getWinnersInstance();
    }
}
