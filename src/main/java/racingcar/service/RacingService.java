package racingcar.service;

import racingcar.dto.RacingResult;
import racingcar.model.Racing;

public class RacingService {

    public RacingResult racing(Racing racing) {
        racing.start();

        return new RacingResult(racing.getRacingRecord(), racing.getWinners());
    }
}
