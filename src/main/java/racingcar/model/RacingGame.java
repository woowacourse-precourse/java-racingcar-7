package racingcar.model;

import java.util.List;

public class RacingGame {

    private final Players players;

    public RacingGame(Players players) {
        this.players = players;
    }

    public void round() {
        for (Car car : players.getPlayers()) {
            car.move();
        }
    }

    public List<Car> checkWinner() {
        return players.getWinner();
    }
}
