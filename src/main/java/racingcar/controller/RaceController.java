package racingcar.controller;

import racingcar.dto.RaceRequest;
import racingcar.service.RaceService;

public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public String startRace(String command, Integer iterations) {
        RaceRequest request = new RaceRequest(command, iterations);
        return raceService.startRace(request);
    }
}
