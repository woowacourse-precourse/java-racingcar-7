package racingcar.service;

import java.util.List;
import java.util.Map;
import racingcar.domain.RacingCarGame;
import racingcar.util.RandomNumber;

public class RacingCarService {

    private RacingCarGame racingCarGame;

    public void prepare(List<String> carNames, RandomNumber randomNumber) {
        racingCarGame = RacingCarGame.create(carNames, randomNumber);
    }

    public void race(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            racingCarGame.moveCars();
        }
    }

    public Map<String, Integer> getMoveResult() {
        return racingCarGame.getMoveResult();
    }

    public List<String> findWinnerCars() {
        return racingCarGame.findMaxMoveCars();
    }
}
