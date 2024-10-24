package racingcar.controller;

import java.util.List;
import racingcar.dto.InputDTO;
import racingcar.dto.OutputDTO;
import racingcar.model.RacingCar;
import racingcar.model.Racing;
import racingcar.model.RacingResult;

public class RacingController {

    public static OutputDTO execute(InputDTO inputDTO) {
        int totalTrialCount = inputDTO.getTotalTrialCount();

        Racing racing = new Racing(inputDTO.getRacerNames());
        racing.start(totalTrialCount);
        List<RacingCar> raceResult = racing.getRacingRecord();

        RacingResult racingResult = new RacingResult(raceResult, totalTrialCount);
        List<String> winners = racingResult.findWinner();

        return new OutputDTO(raceResult, winners);
    }
}
