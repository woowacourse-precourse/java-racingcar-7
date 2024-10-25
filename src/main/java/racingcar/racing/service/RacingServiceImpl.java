package racingcar.racing.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.annotation.Service;
import racingcar.racing.dto.request.RacingRequestDTO;
import racingcar.racing.dto.response.RacingResponseDTO;

@Service
public class RacingServiceImpl implements RacingService {

    @Override
    public RacingResponseDTO race(RacingRequestDTO racingRequestDTO) {
        return null;
    }

    private Integer randomMove() {
        return Boolean.compare(4 <= Randoms.pickNumberInRange(0, 9), false);
    }
}
