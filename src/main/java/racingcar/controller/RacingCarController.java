package racingcar.controller;

import racingcar.domain.Car;
import racingcar.dto.request.RaceRequest;
import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RaceResponse;
import racingcar.dto.response.RacingCarResponse;
import racingcar.dto.request.RoundRequest;
import racingcar.dto.response.RoundResponse;
import racingcar.service.RacingCarService;
import racingcar.util.Container;

import java.util.List;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.racingCarService = Container.getInstance(RacingCarService.class);
    }

    public RacingCarResponse setRacingCars(RacingCarRequest request) {
        List<Car> cars = racingCarService.setRacingCars(request);
        return RacingCarResponse.from(cars);
    }

    public RoundResponse setRound(RoundRequest request) {
        int roundNum = racingCarService.setRound(request);
        return RoundResponse.from(roundNum);
    }

    public RaceResponse startRace(RaceRequest request) {
        List<String> winners = racingCarService.startRace(request);
        return RaceResponse.from(winners);
    }
}
