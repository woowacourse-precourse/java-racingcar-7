package racingcar.controller;

import racingcar.domain.Race;
import racingcar.service.RaceService;

public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public String doRace(String raceCarNames, String moveCount) {
        Race race = raceService.doRace(raceCarNames,moveCount);
        return raceService.getRaceResult(race);
    }
}
