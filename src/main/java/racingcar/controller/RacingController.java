package racingcar.controller;

import java.util.List;
import racingcar.dto.OutputDTO;
import racingcar.model.Racing;
import racingcar.model.RacingResult;

public class RacingController {

    public static RacingResult startRace(List<String> racerNames, Integer totalTrialCount) {
        Racing racing = new Racing(racerNames);

        racing.start(totalTrialCount);

        return new RacingResult(racing.getRacingRecord());
    }

    public static OutputDTO announceResult(RacingResult racingResult, Integer totalTrialCount) {
        List<String> winners = racingResult.findWinner(totalTrialCount);

        return new OutputDTO(racingResult.get(), winners, totalTrialCount);
    }
}
