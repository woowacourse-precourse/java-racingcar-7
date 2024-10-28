package racingcar.game;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import racingcar.player.Player;

public class Game {
    final List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
    }

    public List<String> winner() {
        Integer highestScore = players.stream()
                .max(Comparator.<Player>comparingInt(Player::getScore))
                .map(Player::getScore)
                .orElse(0);

        return players.stream()
                .filter(player -> player.getScore().equals(highestScore))
                .map(Player::getName)
                .toList();
    }

    public List<Player> play(Integer Score, Predicate<Player> scoreRule) {
        for(Player player : players) {
            if (scoreRule.test(player)) {
                player.winGame(Score);
            }
        }
        return players;
    }
}
