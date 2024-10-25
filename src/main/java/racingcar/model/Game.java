package racingcar.model;

import java.util.List;

public class Game {
    private final Cars cars;
    private int round;

    private Game(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public static Game start(List<String> carNames, int round) {
        return new Game(Cars.apply(carNames), round);
    }

    public void play() {
        cars.playRound();
        round--;
    }

    public boolean isGameEnd() {
        if (round == 0) {
            return true;
        }
        return false;
    }
}
