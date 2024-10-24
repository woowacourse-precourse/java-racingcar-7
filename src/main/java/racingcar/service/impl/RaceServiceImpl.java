package racingcar.service.impl;

import java.util.List;
import racingcar.domain.CarDomain;
import racingcar.domain.RaceDomain;
import racingcar.service.RaceService;

public class RaceServiceImpl implements RaceService {
    @Override
    public void runRoundRace(RaceDomain race) {
        race.getCars().forEach(CarDomain::attemptMove);
    }

    @Override
    public List<CarDomain> getWinners(RaceDomain race) {
        return race.getWinnersInstance();
    }
}
