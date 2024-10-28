package racingcar.controller;

import racingcar.model.dto.RacingRequestDTO;
import racingcar.model.dto.RacingResponseDTO;
import racingcar.service.RacingService;
import racingcar.service.ValidatorService;

public class RacingController {
    private final RacingService racingService;
    private final ValidatorService validatorService;

    public RacingController(RacingService racingService, ValidatorService validatorService) {
        this.racingService = racingService;
        this.validatorService = validatorService;
    }

    public RacingResponseDTO start(RacingRequestDTO racingRequestDTO) {
        validatorService.validate(racingRequestDTO);
        return racingService.race(racingRequestDTO);
    }
}
