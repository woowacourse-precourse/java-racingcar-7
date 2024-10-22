package racingcar.service;

import racingcar.dto.RacingResult;
import racingcar.model.Racing;

public class RacingService {

    public RacingResult racing(Racing racing) {
        racing.startRacing();

        return new RacingResult(racing.getRacingRecord(), racing.getWinners());
    }
}
