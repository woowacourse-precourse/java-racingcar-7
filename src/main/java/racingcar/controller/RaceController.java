package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.request.RaceCreateRequest;
import racingcar.response.RoundResponse;
import racingcar.response.WinnerResponse;
import racingcar.service.RaceService;

public class RaceController {
    private final RaceService service;

    public RaceController() {
        this.service = new RaceService();
    }

    public void createRace(RaceCreateRequest request) {
        service.createRace(request.getNames(), request.getTryCount());
    }

    public RoundResponse playRound() {
        List<Car> movedCars = service.playRound();
        boolean isGameEnd = service.isGameEnd();

        return new RoundResponse(movedCars, isGameEnd);
    }

    public WinnerResponse getWinner() {
        List<Car> winners = service.getWinner();

        return new WinnerResponse(winners);
    }
}
