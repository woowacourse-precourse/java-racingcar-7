package racingcar.service;

import racingcar.dto.request.RacingRequestDTO;
import racingcar.dto.response.RacingResponseDTO;

public interface RacingService {
    RacingResponseDTO race(RacingRequestDTO racingRequestDTO);
}
