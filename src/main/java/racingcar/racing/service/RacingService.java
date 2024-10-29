package racingcar.racing.service;

import racingcar.racing.dto.request.RacingRequestDTO;
import racingcar.racing.dto.response.RacingResponseDTO;

public interface RacingService {

    RacingResponseDTO race(RacingRequestDTO racingRequestDTO);
}
