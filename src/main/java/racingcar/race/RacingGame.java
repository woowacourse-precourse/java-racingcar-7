package racingcar.race;

import racingcar.component.RacingCar;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int matchCount;

    public RacingGame(List<RacingCar> racingCars, int matchCount) {
        this.racingCars = racingCars;
        this.matchCount = matchCount;
    }

    public void play() {
        for (int i = 0; i < matchCount; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

}
