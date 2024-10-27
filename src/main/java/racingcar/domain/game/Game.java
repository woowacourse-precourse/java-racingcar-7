package racingcar.domain.game;

import java.util.List;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.player.Player;
import racingcar.domain.player.Players;

public class Game {
    private final Players players;
    private final Round round;
    private final MovementPolicy movementPolicy;

    private Game(Players players, int totalRounds, MovementPolicy movementPolicy) {
        this.players = players;
        this.round = Round.of(totalRounds);
        this.movementPolicy = movementPolicy;
    }

    public static Game start(List<Player> players, int totalRounds, MovementPolicy movementPolicy) {
        return new Game(Players.from(players), totalRounds, movementPolicy);
    }
}
