package racingcar.controller;

import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RacingCarResponse;
import racingcar.service.RacingCarService;

import java.util.List;
import java.util.Map;

public class RacingCarController {
    private final RacingCarService racingCarService = new RacingCarService();

    public RacingCarResponse runRace(RacingCarRequest racingCarRequest) {
        List<Map<String, String>> moveRecords = racingCarService.racing(racingCarRequest.carName(), racingCarRequest.attemptCount());
        String winner = racingCarService.findWinner(moveRecords.get(moveRecords.size() - 1));
        return RacingCarResponse.from(moveRecords, winner);
    }
}
