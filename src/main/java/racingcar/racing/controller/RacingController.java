package racingcar.racing.controller;

import racingcar.global.annotation.Controller;
import racingcar.racing.dto.request.RacingRequestDTO;
import racingcar.racing.dto.response.RacingResponseDTO;
import racingcar.racing.service.RacingService;

@Controller
public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public RacingResponseDTO racing(RacingRequestDTO racingRequestDTO) {
        return racingService.race(racingRequestDTO);
    }
}
