package racingcar.service;

import racingcar.model.RacingCars;
import racingcar.model.moving_strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final MovingStrategy movingStrategy;

    public RacingService(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

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
        racingCars.move();
        return new RacingRoundResult(racingCars.getCarNamesAndPositions());
    }
}
