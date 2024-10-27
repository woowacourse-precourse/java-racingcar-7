package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<String> findWinners() {
        return cars.findWinner();
    }

    public boolean isGameEnd() {
        if (isRoundZero()) {
            return true;
        }
        return false;
    }

    private boolean isRoundZero() {
        return round == 0;
    }

    public List<String> getStatus() {
        return cars.getStatus();
    }
}
