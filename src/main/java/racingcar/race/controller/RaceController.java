package racingcar.race.controller;

import racingcar.race.service.RaceService;

public class RaceController {
    public int raceEnterRound() {
        RaceService raceService = new RaceService();
        return raceService.enterRaceNumber();
    }
}
