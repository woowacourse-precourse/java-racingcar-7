package racingcar.controller;

import java.util.List;
import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RacingCarWinnerResponse;
import racingcar.service.RacingCarService;
import racingcar.util.SingletonObjectProvider;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.racingCarService = SingletonObjectProvider.getSingletonObject(RacingCarService.class);
    }

    public RacingCarWinnerResponse calculate(RacingCarRequest request) {
        List<String> winners = racingCarService.playRacingCar(request);
        return RacingCarWinnerResponse.from(winners);
    }
}
