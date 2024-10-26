package racingcar.controller;

import racingcar.dto.CreateCarsRequest;
import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceRequest;
import racingcar.dto.StartRaceResponse;
import racingcar.service.RaceService;

public class RaceController {

    private static final String DELIMITERS = ",";
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void createCars(CreateCarsRequest request) {
        raceService.createCars(parseCarName(request.carNames()));
    }

    public StartRaceResponse startRace(StartRaceRequest request) {
        return raceService.startRace(request.attemptCount());
    }

    public GetWinnersResponse getWinners() {
        return raceService.getWinners();
    }

    public String[] parseCarName(String carNames) {
        return carNames.split(DELIMITERS);
    }
}