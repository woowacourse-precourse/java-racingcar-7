package racingcar;

import java.util.List;

public class Game {
    private final Integer round;
    private final List<RacingCar> racingCars;

    public Game(Integer round, List<RacingCar> racingCars) {
        this.round = round;
        this.racingCars = racingCars;
    }

    public Integer getRound() {
        return round;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
