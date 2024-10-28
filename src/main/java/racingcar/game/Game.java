package racingcar.game;

import java.util.List;
import java.util.function.Supplier;
import racingcar.player.Player;

public class Game {
    final List<Player> players;
    Integer turn;

    public Game(List<Player> players, Integer turn) {
        this.players = players;
        this.turn = turn;
    }

    public List<String> winner() {
        return players.stream()
                .sorted()
                .filter(player -> player.getScore().equals(players.getFirst().getScore()))
                .map(Player::getName)
                .toList();
    }

    public List<Player> play(Integer Score, Supplier<Boolean> scoreRule) {
        for(Player player : players) {
            if (scoreRule.get()) {
                player.winGame(Score);
            }
        }
        return players;
    }
}
