package racingcar.controller;

import racingcar.dto.CreateCarsRequest;
import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceRequest;
import racingcar.dto.StartRaceResponse;
import racingcar.service.CarService;
import racingcar.service.RaceService;
import racingcar.util.Parser;

public class RaceController {

    private final RaceService raceService;
    private final CarService carService;

    public RaceController(RaceService raceService, CarService carService) {
        this.raceService = raceService;
        this.carService = carService;
    }

    public void createCars(CreateCarsRequest request) {
        carService.createCars(Parser.parseDelimitersString(request.carNames()));
    }

    public StartRaceResponse startRace(StartRaceRequest request) {
        return raceService.startRace(request.attemptCount());
    }

    public GetWinnersResponse getWinners() {
        return raceService.getWinners();
    }
}