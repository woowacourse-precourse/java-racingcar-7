package racingcar.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.domain.RacingCars;
import racingcar.domain.Winning;

public class RacingCarService {

    private final RacingCars racingCars;
    private final Winning winning;

    public RacingCarService(RacingCars racingCars, Winning winning) {
        this.racingCars = racingCars;
        this.winning = winning;
    }

    public Map<String, Integer> getNewCars(List<String> splitCarNames) {
        return racingCars.initializeCars(splitCarNames);
    }

    public void raceOneRound() {
        racingCars.attemptMoveCarsInOneRound();
    }

    public void getMaxPosition(Map<String, Integer> cars) {
        winning.findMaxPosition(cars);
    }

    public Set<String> getWinningCars(Map<String, Integer> cars) {
        return winning.findWinningCars(cars);
    }
}
