package racingcar.controller;

import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceRequest;
import racingcar.dto.StartRaceResponse;
import racingcar.service.RaceService;

public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public StartRaceResponse startRace(StartRaceRequest request) {
        return raceService.startRace(request.attemptCount());
    }

    public GetWinnersResponse getWinners() {
        return raceService.getWinners();
    }
}