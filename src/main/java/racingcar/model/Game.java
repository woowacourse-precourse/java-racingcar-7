package racingcar.model;

import java.util.List;

public class Game {
    private final List<Car> players;
    private final int totalRound;
    private int currentRound;

    public Game(List<Car> players, String totalRound) {
        GameValidator.validate(totalRound);

        this.players = players;
        this.totalRound = Integer.parseInt(totalRound);
        this.currentRound = 0;
    }

}
