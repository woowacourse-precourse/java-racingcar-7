package racingcar.controller;

import java.util.List;
import racingcar.dto.InputDTO;
import racingcar.dto.OutputDTO;
import racingcar.model.RacingCar;
import racingcar.model.Racing;

public class RacingController {

    private RacingController() {
    }

    public static OutputDTO execute(InputDTO inputDTO) {
        Racing racing = new Racing(inputDTO.getRacerNames(), inputDTO.getTrialCount());
        List<RacingCar> raceResult = racing.startRace();

        int maxMoves = racing.findMaxMoves();
        List<String> winners = racing.findWinners(maxMoves);

        return new OutputDTO(raceResult, winners);
    }
}
