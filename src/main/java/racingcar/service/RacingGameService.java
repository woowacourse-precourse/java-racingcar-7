package racingcar.service;

import racingcar.model.RacingGame;

public class RacingGameService {
    private RacingGame racingGame;

    public void initialize(String[] names, int tryCount) {
        this.racingGame = new RacingGame(names, tryCount);
    }

    public void startRace() {
        racingGame.start();
    }

    public String getWinners() {
        return racingGame.getWinners();
    }
}
