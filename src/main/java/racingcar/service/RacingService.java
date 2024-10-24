package racingcar.service;

import racingcar.model.RacingCars;
import racingcar.util.ramdom.RandomRange;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final RandomRange RANDOM_RANGE = new RandomRange(0, 9);
    private RacingCars racingCars;

    public void setRacingCars(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void playRound() {
        validateRacingCarsExistence();
        racingCars.moveRandomly(RANDOM_RANGE);
    }

    private void validateRacingCarsExistence() {
        if (racingCars == null) {
            throw new IllegalStateException("게임을 시작하기 위한 자동차가 존재하지 않습니다.");
        }
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
