package racingcar.controller;

import racingcar.service.RaceService;

public class RaceController {

    private final RaceService raceService;

    public RaceController() {
        raceService = new RaceService();
    }

    public void run() {
        raceService.setCars();
        raceService.setRaceCount();
        raceService.play();
        raceService.getWinners();
    }
}
