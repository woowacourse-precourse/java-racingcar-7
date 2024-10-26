package racingcar.service;

import racingcar.domain.RacingGame;

public interface RacingCarService {
    void startRace(String carNames, int tryCount);
    RacingGame getRacingGame();
}
