package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;
import java.util.List;


public class RacingGame {
    private static final int INITIAL_ROUND = 0;
    private int tryCount;
    private int currentRound;
    private final CarManager carManager;
    private final RoundManager roundManager;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.carManager = new CarManager(randomNumberGenerator);
        this.roundManager = new RoundManager();
    }

    public void initialize(String carNames, int tryCount) {
        this.carManager.initializeCars(carNames);
        this.tryCount = tryCount;
        this.currentRound = INITIAL_ROUND;
    }

    public boolean hasNextRound() {
        return currentRound < tryCount;
    }

    public void playRound() {
        carManager.playRound();
        roundManager.recordRoundResult(carManager.getCurrentRoundResults());
        currentRound++;
    }

    public List<List<String>> getAllRoundResults() {
        return roundManager.getAllRoundResults();
    }

    public List<String> getWinners() {
        return carManager.getWinners();
    }
}
