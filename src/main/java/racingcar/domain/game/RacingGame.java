package racingcar.domain.game;

import racingcar.domain.car.Cars;

public class RacingGame implements Game {
    private final Cars cars;
    private final RacingGameCount racingCount;
    private RacingGameState racingGameState;
    private int currentRound;

    public RacingGame(Cars cars, RacingGameCount racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
        this.currentRound = 0;
        initializeGameState();
    }

    @Override
    public void play() {
        while (!isGameFinished()) {
            playOneRound();
        }
        updateFinalGameState();
    }

    public void playOneRound() {
        if (isGameFinished()) {
            return;
        }
        moveAndUpdateRound();
        updateGameState();
    }

    private void moveAndUpdateRound() {
        cars.moveAllCarsRandomly();
        currentRound++;
    }

    private void updateGameState() {
        if (isGameFinished()) {
            updateFinalGameState();
            return;
        }
        updateRoundState();
    }

    private void initializeGameState() {
        racingGameState = new RacingGameState(cars.createRoundResults(), null);
    }

    public boolean isGameFinished() {
        return currentRound >= racingCount.getTryCountValue();
    }

    private void updateRoundState() {
        racingGameState = new RacingGameState(cars.createRoundResults(), null);
    }

    private void updateFinalGameState() {
        racingGameState = new RacingGameState(cars.createRoundResults(), cars.findWinners());
    }

    public RacingGameState getGameState() {
        return racingGameState;
    }
}
