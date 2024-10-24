package racingcar.race;

import racingcar.component.RacingCar;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final MatchResolver matchResolver;
    private final int matchCount;
    private int currentRound;

    public RacingGame(List<RacingCar> racingCars, int matchCount) {
        this.racingCars = racingCars;
        this.matchResolver = new MatchResolver();
        this.matchCount = matchCount;
        this.currentRound = 1;
    }

    public void play() {
        while (goToNextRound()) {
            playRound();
        }
    }

    public List<RacingCar> getWinners() {
        return matchResolver.determineWinner(racingCars);
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
