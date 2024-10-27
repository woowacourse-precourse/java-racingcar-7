package racingcar.racingcar.service.racing;

import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.trynumber.domain.TryNumber;

public interface RacingService {
    void racing(RacingCarInfo racingCarInfo, TryNumber tryNumber);
}
