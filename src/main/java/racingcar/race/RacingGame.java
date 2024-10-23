package racingcar.race;

import racingcar.component.RacingCar;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int matchCount;
    private int currentRound;

    public RacingGame(List<RacingCar> racingCars, int matchCount) {
        this.racingCars = racingCars;
        this.matchCount = matchCount;
        this.currentRound = 1;
    }

    public void play() {
        while (goToNextRound()) {
            playRound();
        }
    }

    private void playRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    private boolean goToNextRound() {
        doBetweenRound();
        if (isLastRound()) {
            return false;
        }
        currentRound++;
        return true;
    }

    private boolean isLastRound() {
        return currentRound == matchCount;
    }

    private void doBetweenRound() {
        System.out.println();
    }

}
