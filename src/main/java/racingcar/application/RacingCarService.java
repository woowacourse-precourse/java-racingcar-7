package racingcar.application;

import racingcar.domain.application.RaceService;

public class RacingCarService {

    private final RaceService raceService;

    public RacingCarService(RaceService raceService) {
        this.raceService = raceService;
    }

}
