package racingcar;

import java.util.List;

public class Game {
    private final Integer round;
    private final List<RacingCar> racingCars;

    private Game(Integer round, List<RacingCar> racingCars) {
        this.round = round;
        this.racingCars = racingCars;
    }

    public static Game createGame(Integer round, List<RacingCar> racingCars) {
        return new Game(round, racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public Integer getRound() {
        return round;
    }
}
