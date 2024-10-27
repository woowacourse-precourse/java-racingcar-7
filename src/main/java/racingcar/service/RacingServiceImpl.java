package racingcar.service;

import java.util.List;
import racingcar.domain.model.RacingManager;
import racingcar.dto.request.RacingRequestDTO;
import racingcar.dto.response.RacingResponseDTO;

public class RacingServiceImpl implements RacingService {

    @Override
    public RacingResponseDTO race(RacingRequestDTO racingRequestDTO) {
        RacingManager racingManager = initializeParticipants(racingRequestDTO.carNames());
        int moveCount = racingRequestDTO.moveCount();
        return null;
    }

    private RacingManager initializeParticipants(List<String> carNames) {
        return RacingManager.createWithCars(carNames);
    }
}
