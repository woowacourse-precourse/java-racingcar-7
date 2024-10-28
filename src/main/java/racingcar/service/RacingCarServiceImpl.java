package racingcar.service;

import racingcar.domain.RacingGame;
import racingcar.utils.RandomNumberGenerator;

public class RacingCarServiceImpl implements RacingCarService{
    private final RacingGame racingGame;
    public RacingCarServiceImpl(RandomNumberGenerator randomNumberGenerator) {
        this.racingGame = new RacingGame(randomNumberGenerator);
    }

    @Override
    public void startRace(String carNames, int tryCount) {

    }

    @Override
    public RacingGame getRacingGame() {
        return racingGame;
    }
}
