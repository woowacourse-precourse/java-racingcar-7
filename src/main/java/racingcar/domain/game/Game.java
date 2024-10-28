package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Distance;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.player.Player;
import racingcar.domain.player.Players;
import racingcar.exception.game.GameException;

/**
 * - [x] 승자 확인하기 - [x] 단독 승자 확인 - [x] 공동 승자 확인
 */
public class Game {
    private final Players players;
    private final Round round;
    private final MovementPolicy movementPolicy;

    private Game(Players players, Round round, MovementPolicy movementPolicy) {
        this.players = players;
        this.round = round;
        this.movementPolicy = movementPolicy;
    }

    public static Game start(List<Player> players, int totalRounds, MovementPolicy movementPolicy) {
        return new Game(
                Players.from(players),
                Round.of(totalRounds),
                movementPolicy
        );
    }

    public Game play() {
        validateCanPlay();
        Players movedPlayers = moveAllPlayers();
        Round nextRound = round.increase();

        return new Game(movedPlayers, nextRound, movementPolicy);
    }

    public boolean isFinished() {
        return !round.hasNext();
    }

    private void validateCanPlay() {
        if (isFinished()) {
            throw new GameException.GameEndedException();
        }
    }

    private Players moveAllPlayers() {
        return players.move(player -> movePlayer(player));
    }

    private Player movePlayer(Player player) {
        Distance newDistance = movementPolicy.move(player.getDistance());
        return player.move(newDistance);
    }

    public List<Player> getPlayers() {
        return players.getAll();
    }
}
