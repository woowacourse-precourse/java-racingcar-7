package racingcar.controller;

import java.util.List;
import racingcar.dto.OutputDTO;
import racingcar.model.Racing;
import racingcar.model.RacingResult;

public class RacingController {

    public static RacingResult startRace(List<String> racerNames, Integer totalTrialCount) {
        Racing ready = new Racing(racerNames);
        return new RacingResult(ready.start(totalTrialCount));
    }

    public static OutputDTO announceResult(RacingResult racingResult, Integer totalTrialCount) {
        return new OutputDTO(racingResult.getRecord(), racingResult.findWinner(), totalTrialCount);
    }
}
