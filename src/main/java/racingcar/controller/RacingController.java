package racingcar.controller;

import racingcar.dto.CreateCarsRequest;
import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceRequest;
import racingcar.dto.StartRaceResponse;
import racingcar.service.RacingService;

public class RacingController {

    private static final String DELIMITERS = ",";
    private final RacingService racingService = new RacingService();

    public void createCars(CreateCarsRequest request) {
        racingService.createCars(parseCarName(request.carNames()));
    }

    public StartRaceResponse startRace(StartRaceRequest request) {
        return racingService.startRace(request.attemptCount());
    }

    public GetWinnersResponse getWinners() {
        return racingService.getWinners();
    }

    public String[] parseCarName(String carNames) {
        return carNames.split(DELIMITERS);
    }
}