package racingcar.service;

import racingcar.model.RacingCars;
import racingcar.util.ramdom.RandomRange;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final RandomRange RANDOM_RANGE = new RandomRange(0, 9);

    public RacingResult play(RacingCars racingCars, int tryCount) {
        List<RacingRoundResult> racingRoundResults = playRounds(racingCars, tryCount);
        RacingCars winners = getWinners(racingCars);

        return new RacingResult(racingRoundResults, winners);
    }

    private RacingCars getWinners(RacingCars racingCars) {
        return racingCars.getMaxPositionCars();
    }

    private List<RacingRoundResult> playRounds(RacingCars racingCars, int tryCount) {
        List<RacingRoundResult> racingRoundResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingRoundResults.add(playRound(racingCars));
        }

        return racingRoundResults;
    }

    private RacingRoundResult playRound(RacingCars racingCars) {
        racingCars.moveRandomly(RANDOM_RANGE);
        return new RacingRoundResult(racingCars.getCarNamesAndPositions());
    }
}
