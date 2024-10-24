package racingcar.controller;

import java.util.List;
import racingcar.dto.InputDTO;
import racingcar.dto.OutputDTO;
import racingcar.model.Racing;
import racingcar.model.RacingResult;

public class RacingController {

    public static OutputDTO run(InputDTO inputDTO) {
        List<String> racerNames = inputDTO.getRacerNames();
        int totalTrialCount = inputDTO.getTotalTrialCount();

        RacingResult racingResult = startRace(racerNames, totalTrialCount);
        List<String> winners = racingResult.findWinner();

        return new OutputDTO(racingResult.get(), winners, totalTrialCount);
    }

    public static RacingResult startRace(List<String> racerNames, Integer totalTrialCount) {
        Racing racing = new Racing(racerNames);

        racing.start(totalTrialCount);

        return new RacingResult(racing.getRacingRecord(), totalTrialCount);
    }
}
