package racingcar.controller;

import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RacingCarResponse;
import racingcar.service.RacingCarService;

import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public RacingCarResponse processInput(RacingCarRequest racingCarRequest) {
        List<String> winners = racingCarService.playRacingCar(racingCarRequest);
        return RacingCarResponse.from(winners);
    }
}
