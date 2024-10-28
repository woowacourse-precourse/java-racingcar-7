package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.dto.request.RacingRequestDTO;
import racingcar.dto.response.RacingResponseDTO;

public class RacingController {
    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public RacingResponseDTO startRace(RacingRequestDTO racingRequestDTO) {
        return racingService.race(racingRequestDTO);
    }
}
