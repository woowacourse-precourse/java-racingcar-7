package racingcar.controller;

import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;
import racingcar.service.RacingService;

public class RacingController {

    private static final String DELIMITERS = ",";
    private final RacingService racingService = new RacingService();

    public RacingResponse startRace(RacingRequest request){
        String[] carName = parseCarName(request.carNames());
        int attemptCount = request.attemptCount();

        return racingService.startRace(carName, attemptCount);
    }

    public String[] parseCarName(String carNames){
        return carNames.split(DELIMITERS);
    }
}