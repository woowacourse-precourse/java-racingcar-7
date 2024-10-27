package racingcar.service.impl;

import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;
import racingcar.service.RaceService;

public class RaceServiceImpl implements RaceService {

    private static RaceServiceImpl INSTANCE;

    private RaceServiceImpl() {
    }

    public static synchronized RaceServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RaceServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public void runOneRound(RaceDomain race) {
        race.executeOneRound();
    }

    @Override
    public CarDomains getWinners(RaceDomain race) {
        return race.getWinnersInstance();
    }
}
