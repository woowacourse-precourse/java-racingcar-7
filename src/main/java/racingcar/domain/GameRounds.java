package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRounds {
    private final List<Cars> gameRounds;

    public GameRounds() {
        this.gameRounds = new ArrayList<>();
    }

    public void addGameRound(Cars gameRound) {
        gameRounds.add(gameRound);
    }

    public List<Cars> getGameRoundList() {
        return List.copyOf(gameRounds);
    }
}
